package com.hotelratingsystem.UserService.exceptions;

public class DuplicatedIdException extends  RuntimeException{

    public DuplicatedIdException(String message){
        super(message);
    }
}
