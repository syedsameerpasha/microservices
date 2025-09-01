package com.example.RatingService.exceptuions;

public class RatingIdNotFoundException extends RuntimeException{
    public RatingIdNotFoundException(String message){
        super(message);
    }
}
