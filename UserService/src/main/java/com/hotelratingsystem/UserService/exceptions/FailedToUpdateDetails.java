package com.hotelratingsystem.UserService.exceptions;

public class FailedToUpdateDetails extends RuntimeException{

    public FailedToUpdateDetails(String message){
        super(message);
    }

}
