package com.example.RatingService.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ratingdb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDocument {
    @Id
    @Field
    private String ratingId;
    @Field
    private String userId;
    @Field
    private String rating;
}
