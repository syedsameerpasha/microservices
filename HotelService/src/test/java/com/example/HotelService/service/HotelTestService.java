package com.example.HotelService.service;

import com.example.HotelService.document.HotelDocument;
import com.example.HotelService.dto.HotelDto;
import com.example.HotelService.mongo.HotelImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HotelTestService {
    @Mock
    HotelImpl hotel;

    @InjectMocks
    HotelService hotelService;
    @Test
    void getMethodShouldGetHotelDetails(){
        String hotelId= "100";
        HotelDocument hotelDocument= new HotelDocument();
        hotelDocument.setHotelId(hotelId);
        hotelDocument.setHotelName("TAJ");
        hotelDocument.setHotelPassword("12345678");
        Mockito.when(hotel.getHotelDetails(hotelId)).thenReturn(hotelDocument);

        HotelDto hotelDetails = hotelService.getHotelDetails(hotelId);


        Assertions.assertEquals("TAJ",hotelDetails.getHotelName());

    }
}
