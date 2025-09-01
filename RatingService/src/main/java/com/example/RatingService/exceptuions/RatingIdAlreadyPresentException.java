package com.example.RatingService.exceptuions;

public class RatingIdAlreadyPresentException extends  RuntimeException{
    public RatingIdAlreadyPresentException(String message){
        super(message);
    }

}
