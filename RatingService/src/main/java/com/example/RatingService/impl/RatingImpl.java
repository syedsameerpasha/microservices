package com.example.RatingService.impl;

import com.example.RatingService.document.RatingDocument;
import com.example.RatingService.dto.RatingDto;
import com.example.RatingService.exceptuions.RatingIdAlreadyPresentException;
import com.example.RatingService.exceptuions.RatingIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class RatingImpl {
    @Autowired
    private MongoTemplate mongoTemplate;
    public RatingDocument createRating(RatingDocument ratingDocument) {

        RatingDocument existing = mongoTemplate.findById(ratingDocument.getRatingId(), RatingDocument.class);

        if(existing != null ){
            throw new RatingIdAlreadyPresentException("please pass unique rating id");
        }
        return mongoTemplate.save(ratingDocument);
    }

    public RatingDocument getRating(String ratingId) {
        RatingDocument document = mongoTemplate.findById(ratingId, RatingDocument.class);

        if(document == null){
            throw new RatingIdNotFoundException("rating id not found");
        }

        return document;


    }
}
