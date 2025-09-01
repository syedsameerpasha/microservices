package com.example.RatingService.service;

import com.example.RatingService.document.RatingDocument;
import com.example.RatingService.dto.RatingDto;
import com.example.RatingService.exceptuions.RatingDtoCannotBeEmptyException;
import com.example.RatingService.exceptuions.RatingIdIsMustToGetRatings;
import com.example.RatingService.impl.RatingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class RatingService {
    @Autowired
    private RatingImpl rating;
    public RatingDto createRating(RatingDto ratingDto) {


        RatingDocument ratingDocument=new RatingDocument();
        ratingDocument.setRatingId(ratingDto.getRatingId());
        ratingDocument.setRating(ratingDto.getRating());
        ratingDocument.setUserId(ratingDto.getUserId());


        RatingDocument rating1 = rating.createRating(ratingDocument);
        RatingDto ratingDto1 = new RatingDto();
        ratingDto1.setRatingId(ratingDocument.getRatingId());
        ratingDto1.setRating(ratingDocument.getRating());
        ratingDto1.setUserId(ratingDocument.getUserId());
        return ratingDto1;
    }

    public RatingDto getRatings(String ratingId) {
        if(!StringUtils.hasText(ratingId)){
            throw new RatingIdIsMustToGetRatings("rating id is manadtory");
        }

        RatingDocument ratingDocument = rating.getRating(ratingId);
        RatingDto ratingDto=new RatingDto();
        ratingDto.setRatingId(ratingDocument.getRatingId());
        ratingDto.setUserId(ratingDocument.getUserId());
        ratingDto.setRating(ratingDocument.getRating());
        return  ratingDto;

    }
}
