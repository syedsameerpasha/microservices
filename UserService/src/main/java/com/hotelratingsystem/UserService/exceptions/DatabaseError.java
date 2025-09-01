package com.hotelratingsystem.UserService.exceptions;

public class DatabaseError extends RuntimeException{

    public DatabaseError(String message){
        super(message);
    }

    public DatabaseError(){
        super("databse not connected or databse error");
    }


}
