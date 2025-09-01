package com.example.HotelService.exceptions;

public class IdNotFoundException extends  RuntimeException{

    public IdNotFoundException(String message){
        super(message);
    }
}
