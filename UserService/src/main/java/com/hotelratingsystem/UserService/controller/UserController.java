package com.hotelratingsystem.UserService.controller;

import com.hotelratingsystem.UserService.dto.UserDto;
import com.hotelratingsystem.UserService.response.UserResponse;
import com.hotelratingsystem.UserService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
     @Autowired
    public  UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/create")
    public UserDto createUser( @Valid  @RequestBody UserDto userDto){


        return userService.createUser(userDto);

    }
    @GetMapping("/get")
    public UserDto getUser(@RequestParam(required = false) String id){
         return userService.getUser(id);

    }
    @PutMapping("/update")
    public UserDto updateUser(@RequestParam(required = false) String id,@RequestBody UserDto userDto){
        return userService.updateUser(id,userDto);
    }
    @GetMapping("/hotel/user/get")
    public UserResponse getUserWithHotel(@RequestParam String id){
      return  userService.getUserById(id);
    }


}
