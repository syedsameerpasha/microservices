package com.example.HotelService.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    ErrorResponse errorResponse;
    @ExceptionHandler(HotelIdMandatoryException.class)
    public ResponseEntity<ErrorResponse> failedToGetDetails(HotelIdMandatoryException ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.BAD_REQUEST.toString());
     errorResponse.setMesssage("BAD REQUEST");
     errorResponse.setDetails(ex.getMessage());
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorResponse> failedToGetDetails(IdNotFoundException ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_FOUND.toString());
        errorResponse.setMesssage("NOT FOUND");
        errorResponse.setDetails(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(DatabaseError.class)
    public ResponseEntity<ErrorResponse> failedToGetDetails(DatabaseError ex){
        ErrorResponse errorResponse= new ErrorResponse();
        errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorResponse.setMesssage("Server down");
        errorResponse.setDetails(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
