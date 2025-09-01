package com.example.HotelService.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "hoteldb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDocument {
    @Field
    private String hotelId;
    @Field
    private String hotelName;
    @Field
    private String hotelPassword;
}
