package com.hotelratingsystem.UserService.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class UserDto {

    private String id;



    private String name;



    private String address;

    private LocalDate dob;
    private String hotelId;

    private String ratingId;
}

//past only works with date and @Past works only on date/time types like java.util.Date, java.time.LocalDate, java.time.LocalDateTime, etc.
//
//You declared dob as String, so validation will be ignored or fail silently.
//dont use notblank on localdate use null

//to make sure this annotations works
// use annotations,jakarta nd hibernate validtor depdency and in controller use valid annoations
//Why is it overwriting instead of throwing an error?
//In JPA (e.g., with Spring Data JPA), the save() method behaves as:
//
//Insert if the entity ID does not exist in the database.
//
//Update if the entity ID already exists in the database.
//
//So if you call save() with an existing ID, JPA will update the existing record with new data instead of throwing an error.
