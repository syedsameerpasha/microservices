package com.example.HotelService.controller;

import com.example.HotelService.dto.HotelDto;
import com.example.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping("/get")
    public HotelDto getHotelDetails(@RequestParam String hotelId){
        return hotelService.getHotelDetails(hotelId);


    }
}
