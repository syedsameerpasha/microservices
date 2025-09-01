package com.example.RatingService.service;

import com.example.RatingService.document.RatingDocument;
import com.example.RatingService.dto.RatingDto;
import com.example.RatingService.impl.RatingImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {
    @Mock
    RatingImpl rating;
    @InjectMocks
    RatingService ratingService;

    @Test
    void createRatingShouldAddRatingIndB(){

        RatingDto ratingDto=new RatingDto("1","100","9");

        RatingDocument ratingDocument= new RatingDocument(ratingDto.getRatingId(), ratingDto.getUserId(), ratingDto.getRating());

        Mockito.when(rating.createRating(Mockito.any(RatingDocument.class))).thenReturn(ratingDocument);

        RatingDto rating1 = ratingService.createRating(ratingDto);

        Assertions.assertEquals("100",rating1.getUserId());


    }
    @Test
    void  getRatingsShouldGetRatings(){

        
         String ratingId ="100";
         RatingDocument ratingDocument=new RatingDocument();
         ratingDocument.setRatingId(ratingId);
         ratingDocument.setUserId("102");
         ratingDocument.setRating("8");
         Mockito.when(rating.getRating(ratingId)).thenReturn(ratingDocument);

        RatingDto ratings = ratingService.getRatings(ratingId);

        Assertions.assertEquals("8", ratings.getRating());

    }
}
