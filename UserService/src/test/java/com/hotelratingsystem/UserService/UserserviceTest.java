package com.hotelratingsystem.UserService;

import com.hotelratingsystem.UserService.dto.UserDto;
import com.hotelratingsystem.UserService.entity.UserEntity;
import com.hotelratingsystem.UserService.mongo.UserImpl;
import com.hotelratingsystem.UserService.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class UserserviceTest {
    @Mock
    UserImpl user;
    @InjectMocks
    UserService userService;
    @Test
    void  createUserShouldCreateUserSucessfully(){
        UserDto userDto=new UserDto();
        userDto.setId("90");
        userDto.setName("xyz");
        userDto.setAddress("kol");
        userDto.setDob(LocalDate.parse("2002-09-29"));
        UserEntity userEntity=new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());

        userEntity.setAddress(userDto.getAddress());
        userEntity.setDob(userDto.getDob());
        Mockito.when(user.createUser(Mockito.any(UserEntity.class))).thenReturn(userEntity);
        UserDto user1 = userService.createUser(userDto);



        Assertions.assertEquals("90",user1.getName());

    }
    @Test
    void getUserShouldGETUser(){
        String id="100";
        UserEntity userEntity=new UserEntity();
        String myUser = userEntity.setId(id);
        userEntity.setName("habibi");
        userEntity.setAddress("hyd");
        userEntity.setDob(LocalDate.parse("2000-09-30"));

        Mockito.when(user.getUser(myUser)).thenReturn(userEntity);

        UserDto user1 = userService.getUser(id);

        Assertions.assertEquals("habibi",user1.getName());

    }
    @Test
    void updateUserShouldUpdateUser(){
        String id="101";
        UserDto userDto=new UserDto();
        userDto.setName("syed");
        userDto.setAddress("west indies");
        userDto.setDob(LocalDate.parse("2002-09-20"));

        UserEntity userEntity=new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setDob(userDto.getDob());

        Mockito.when(user.updateUser(id,userDto)).thenReturn(userEntity);

        UserDto userDto1 = userService.updateUser(id, userDto);
        Assertions.assertEquals("syed",userDto1.getName());

    }

}
