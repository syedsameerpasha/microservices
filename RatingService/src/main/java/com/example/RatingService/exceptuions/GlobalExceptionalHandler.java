package com.example.RatingService.exceptuions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(RatingDtoCannotBeEmptyException.class)
    public ResponseEntity<ErrorResponse> emptyRatingObj(RatingDtoCannotBeEmptyException ex){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setType("Rating Object cannot be Empty");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RatingIdAlreadyPresentException.class)
    public ResponseEntity<ErrorResponse> emptyRatingObj(RatingIdAlreadyPresentException ex){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setType("pass unique rating id");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RatingIdIsMustToGetRatings.class)
    public ResponseEntity<ErrorResponse> emptyRatingObj(RatingIdIsMustToGetRatings ex){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setType("rating id is must to get ratings");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RatingIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> emptyRatingObj(RatingIdNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.toString());
        errorResponse.setType("rating id not found");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
