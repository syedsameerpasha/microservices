package com.example.RatingService.exceptuions;

public class RatingIdIsMustToGetRatings extends RuntimeException{
    public RatingIdIsMustToGetRatings(String message){
        super(message);
    }
}
