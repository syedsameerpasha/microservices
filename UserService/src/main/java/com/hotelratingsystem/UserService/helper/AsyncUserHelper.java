package com.hotelratingsystem.UserService.helper;

import com.hotelratingsystem.UserService.config.HotelFeignClient;
import com.hotelratingsystem.UserService.dto.HotelDto;
import com.hotelratingsystem.UserService.dto.RatingDto;
import com.hotelratingsystem.UserService.exceptions.HotelNotFoundException;
import com.hotelratingsystem.UserService.exceptions.HotelServiceNotAvailableException;
import com.hotelratingsystem.UserService.exceptions.RatingServiceisDownException;
import com.hotelratingsystem.UserService.exceptions.RatingsNotFoundForThisUser;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncUserHelper {
    @Autowired
    private HotelFeignClient hotelFeignClient;
    @Autowired
    private RestTemplate restTemplate;

    @Async("asyncExecutor")
    public CompletableFuture<HotelDto> getHotelAsync(String hotelId){
        HotelDto hotelDetailsById;
        try {
            hotelDetailsById = hotelFeignClient.getHotelDetailsById(hotelId);
            if (hotelDetailsById == null){
                throw new HotelNotFoundException("hotel not found for this user");

            }

        }catch (FeignException.NotFound ex){
            throw new HotelNotFoundException("hotel not found for this user");
        }catch (FeignException ex){
            throw new HotelServiceNotAvailableException("hotel service is down");

        }

          return CompletableFuture.completedFuture(hotelDetailsById);
    }
    @Async("asyncExecutor")
    public CompletableFuture<RatingDto> getRatingAsync(String ratingId){
        RatingDto ratingDetailsById;
        try {
            String url1 = "http://localhost:8082/rating/get?ratingId=" + ratingId;
            ratingDetailsById = restTemplate.getForObject(url1, RatingDto.class);
            if(ratingDetailsById == null){
                throw new RatingsNotFoundForThisUser("User never gave any ratings");
            }
        }catch (HttpClientErrorException.NotFound ex){
            throw new RatingsNotFoundForThisUser("this user has never given ratings");
        }catch (RestClientException ex){
            throw new RatingServiceisDownException("rating service is down");
        }
        return CompletableFuture.completedFuture(ratingDetailsById);

    }

}
