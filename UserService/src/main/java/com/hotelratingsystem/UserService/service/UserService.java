package com.hotelratingsystem.UserService.service;

import com.hotelratingsystem.UserService.config.HotelFeignClient;
import com.hotelratingsystem.UserService.dto.HotelDto;
import com.hotelratingsystem.UserService.dto.RatingDto;
import com.hotelratingsystem.UserService.dto.UserDto;
import com.hotelratingsystem.UserService.entity.UserEntity;
import com.hotelratingsystem.UserService.exceptions.*;
import com.hotelratingsystem.UserService.helper.AsyncUserHelper;
import com.hotelratingsystem.UserService.mongo.UserImpl;
import com.hotelratingsystem.UserService.response.UserResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    public UserImpl userImpl;
    @Autowired
    public AsyncUserHelper asyncUserHelper;
    public UserDto createUser(UserDto userDto){
        if( userDto.getId()== null ||userDto.getId().isEmpty()){
           throw new FailedToLoadDetails("Id is mandatory to post data");
        }
        if(userDto.getName()==null|| userDto.getName().isEmpty()){
            throw new FailedToLoadDetails(("Name is must to post data"));
        }
        if(userDto.getAddress()==null|| userDto.getAddress().isEmpty()){
            throw new FailedToLoadDetails(("Address is must to post data"));
        }
        if(userDto.getDob()==null){
            throw new FailedToLoadDetails(("DOB is must to post data"));
        }
        UserEntity userEntity=new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setDob(userDto.getDob());
        userEntity.setHotelId(userDto.getHotelId());

        //save to db
        UserEntity user = userImpl.createUser(userEntity);

       /* UserDto userDto1= UserDto.builder()
                .name(user.getName())
                .Address(user.getAddress())
                .dob(user.getDob())
                .build();*/
        UserDto userDto1=new UserDto();
        userDto1.setName(user.getName());
        userDto1.setAddress(user.getAddress());
        userDto1.setDob(user.getDob());
        userDto1.setHotelId(user.getHotelId());

        return userDto1;



    }

    public UserDto getUser(String id){

        UserEntity entity = userImpl.getUser(id);
        if (entity == null) {
            throw new FailedToGetDetails("ID doesn't exist, please pass a correct ID");
        }
        UserDto userDto=new UserDto();
        userDto.setName(entity.getName());
        userDto.setAddress(entity.getAddress());
        userDto.setDob(entity.getDob());
        userDto.setHotelId(entity.getHotelId());
        return userDto;
    }

    public UserResponse getUserById(String id){
        UserEntity entity =Optional.ofNullable(userImpl.getUser(id)).orElseThrow(()-> new FailedToGetDetails("Id doesnt exist"));

       CompletableFuture<HotelDto> hotelFuture= asyncUserHelper.getHotelAsync(entity.getHotelId()).handle((result, ex)->{
           if (ex != null) {
               log.error("hotel service is down");
               return new HotelDto("NA", "Fallback Hotel");

           }
           return result;
       });
       CompletableFuture<RatingDto> ratingFuture= asyncUserHelper.getRatingAsync(entity.getRatingId()).exceptionally(ex ->{
           log.error("rating service is down");
           return new RatingDto("NA","Fallback hotel","service down");
       });

        try {
            CompletableFuture.allOf(hotelFuture, ratingFuture).join();
            HotelDto hotelDto = hotelFuture.get();
            RatingDto ratingDto = ratingFuture.get();


            return new UserResponse(
                    entity.getName(),
                    entity.getAddress(),
                    entity.getDob(),
                    hotelDto,
                    ratingDto

            );
        }catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed in async execution", e);
        }

    }

    public UserDto updateUser(String id,UserDto userDto) {
        UserEntity userEntity = userImpl.updateUser(id,userDto);
        if(userEntity == null){
            throw new FailedToGetDetails("id doesnt exist,plz pass valid id");
        }



        userDto.setName(userEntity.getName());
        userDto.setAddress(userEntity.getAddress());
        userDto.setDob(userEntity.getDob());
        userDto.setHotelId(userEntity.getHotelId());
        return userDto;
    }
}
