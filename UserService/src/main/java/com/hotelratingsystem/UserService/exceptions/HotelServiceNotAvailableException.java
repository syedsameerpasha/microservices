package com.hotelratingsystem.UserService.exceptions;

public class HotelServiceNotAvailableException extends  RuntimeException{

    public  HotelServiceNotAvailableException(String message){
        super(message);
    }
}
