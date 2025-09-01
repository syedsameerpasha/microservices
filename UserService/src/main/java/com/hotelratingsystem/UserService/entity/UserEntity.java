package com.hotelratingsystem.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "userDb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {


    @Id
    @Field("UserId")
    private String id;
    @Field("UserName")
    private String name;
    @Field("UserAddress")
    private String address;
    @Field("UserDob")
    private LocalDate dob;
    @Field
    private String hotelId;
    @Field
    private String ratingId;






}
