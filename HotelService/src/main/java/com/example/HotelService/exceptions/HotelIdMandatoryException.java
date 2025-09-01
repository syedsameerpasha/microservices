package com.example.HotelService.exceptions;

public class HotelIdMandatoryException extends RuntimeException {

    public HotelIdMandatoryException(String message){
        super(message);
    }
}
