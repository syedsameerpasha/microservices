package com.hotelratingsystem.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHnadler {
    @ExceptionHandler(FailedToLoadDetails.class)
    public ResponseEntity<ErrorResponse> failedtoloaddetails(FailedToLoadDetails ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setType("Required input not provided");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

        @ExceptionHandler(DatabaseError.class)
        public ResponseEntity<ErrorResponse> failedtoconnectdb(DatabaseError ex){
            ErrorResponse errorResponse= new ErrorResponse();
            errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            errorResponse.setType("Server couldn't connect to DB");
            errorResponse.setDetails(ex.getMessage());
            return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @ExceptionHandler(DuplicatedIdException.class)
    public ResponseEntity<ErrorResponse> failedtopost(DuplicatedIdException ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.CONFLICT.toString());
        errorResponse.setType("Duplicate Id");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(FailedToGetDetails.class)
    public ResponseEntity<ErrorResponse> failedtoget(FailedToGetDetails ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.toString());
        errorResponse.setType("Id doesnt exist");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FailedToUpdateDetails.class)
    public ResponseEntity<ErrorResponse> failedtoupdate(FailedToUpdateDetails ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setType("Id doesnt exist");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HotelServiceNotAvailableException.class)
    public ResponseEntity<ErrorResponse> failedtoupdate(HotelServiceNotAvailableException ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorResponse.setType("Hotel service is down");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ErrorResponse> failedtoupdate(HotelNotFoundException ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.toString());
        errorResponse.setType("No hotel for this user");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RatingsNotFoundForThisUser.class)
    public ResponseEntity<ErrorResponse> failedtoupdate(RatingsNotFoundForThisUser ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.toString());
        errorResponse.setType("User has never given any ratings");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RatingServiceisDownException.class)
    public ResponseEntity<ErrorResponse> failedtoupdate(RatingServiceisDownException ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorResponse.setType("Rating service is down");
        errorResponse.setDetails(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

