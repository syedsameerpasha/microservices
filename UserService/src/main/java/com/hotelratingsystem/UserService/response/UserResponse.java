package com.hotelratingsystem.UserService.response;

import com.hotelratingsystem.UserService.dto.HotelDto;
import com.hotelratingsystem.UserService.dto.RatingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String name;
    private String address;
    private LocalDate dob;
    private HotelDto hotelDetails;
    private RatingDto ratingDetails;
}
