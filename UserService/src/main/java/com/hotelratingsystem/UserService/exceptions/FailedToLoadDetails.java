package com.hotelratingsystem.UserService.exceptions;

public class FailedToLoadDetails extends RuntimeException{
    public FailedToLoadDetails(String message){
        super(message);
    }
    public FailedToLoadDetails(){
        super("mandatory data is missing");
    }

}
