package com.example.RatingService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    @NotBlank(message = "Rating ID cannot be blank/null/empty")
    private String ratingId;
    @NotBlank(message = "User ID cannot be blank/null/empty")
    private String userId;
    @NotBlank(message = "Rating cannot be blank/null/empty")
    private String rating;
}
