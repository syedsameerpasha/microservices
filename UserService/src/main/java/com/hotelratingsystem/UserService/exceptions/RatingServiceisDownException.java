package com.hotelratingsystem.UserService.exceptions;

public class RatingServiceisDownException extends RuntimeException{
    public RatingServiceisDownException(String message){
        super(message);
    }
}
