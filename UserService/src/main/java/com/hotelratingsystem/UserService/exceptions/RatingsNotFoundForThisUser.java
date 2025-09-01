package com.hotelratingsystem.UserService.exceptions;

public class RatingsNotFoundForThisUser extends RuntimeException{

    public RatingsNotFoundForThisUser(String message){
        super(message);
    }
}
