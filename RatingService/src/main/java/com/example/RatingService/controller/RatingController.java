package com.example.RatingService.controller;

import com.example.RatingService.dto.RatingDto;
import com.example.RatingService.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping("/create")
    public RatingDto createRating( @Valid @RequestBody RatingDto ratingDto){
        return ratingService.createRating(ratingDto);

    }
    @GetMapping("/get")
    public RatingDto getRating(@RequestParam String ratingId){
        return ratingService.getRatings(ratingId);
    }
}
