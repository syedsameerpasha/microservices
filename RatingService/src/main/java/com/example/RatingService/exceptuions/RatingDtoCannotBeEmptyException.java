package com.example.RatingService.exceptuions;

public class RatingDtoCannotBeEmptyException extends RuntimeException{
    public RatingDtoCannotBeEmptyException(String message){
        super(message);
    }
}
