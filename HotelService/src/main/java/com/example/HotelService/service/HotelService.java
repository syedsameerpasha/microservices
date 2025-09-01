package com.example.HotelService.service;

import com.example.HotelService.document.HotelDocument;
import com.example.HotelService.dto.HotelDto;
import com.example.HotelService.exceptions.HotelIdMandatoryException;
import com.example.HotelService.mongo.HotelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HotelService {
    @Autowired
    private HotelImpl hotel;

    public HotelDto getHotelDetails(String hotelId){

        if(!StringUtils.hasText(hotelId) || "null".equalsIgnoreCase(hotelId) || hotelId.isEmpty()){
            throw new HotelIdMandatoryException("hotel id is mandatory");
        }



        HotelDocument hotelDetails = hotel.getHotelDetails(hotelId);
        //Converting Document to DTO

        HotelDto hotelDto= new HotelDto();
        hotelDto.setHotelId(hotelDetails.getHotelId());
        hotelDto.setHotelName(hotelDetails.getHotelName());

        return hotelDto;

    }

}
