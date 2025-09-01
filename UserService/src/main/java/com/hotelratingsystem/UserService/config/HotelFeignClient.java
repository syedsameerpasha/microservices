package com.hotelratingsystem.UserService.config;

import com.hotelratingsystem.UserService.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.CompletableFuture;

@FeignClient(name = "hotel-service", url = "http://localhost:9090")
public interface HotelFeignClient {
    @GetMapping("/hotel/get")
    HotelDto getHotelDetailsById(@RequestParam String hotelId);
}
