package com.example.resturantreviewtestrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resturantreviewtestrestapi.model.Review ;
import com.example.resturantreviewtestrestapi.service.ReviewService;

@RequestMapping("/api")
@RestController
public class ReviewController {

    @Autowired
    ReviewService service;

    //GET ALL REVIEWS
    @GetMapping("/review")
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    //FIND REVIEW BY ID
    @GetMapping("/review/{id}")
    public Review getReviewById(@PathVariable long id) {
        return service.getReviewById(id);
    }

    //FIND REVIEW BY RATING (filtering reviews based on no of stars)
    @GetMapping("/review/rating/{rating}")
    public List<Review> getReviewsByRating(@PathVariable int rating) {
        return service.getReviewsByRating(rating);
    }

    //CREATE REVIEW
    @PostMapping("/review/add")
    public Review createReview(@RequestBody Review rev) {

        Review newRev = service.createReview(rev);


        return newRev;
    }

    //UPDATE REVIEW
    @PutMapping("/review/update")
    public Review updateReview(@RequestBody Review rev) {

        Review toBeUpdated = service.updateReview(rev);

        return toBeUpdated;
    }

    //DELETE REVIEW
    @DeleteMapping("/review/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String deleteReview(@PathVariable long id) {

        boolean deleted = service.deleteReview(id);

        if(!deleted) {
            return "This review does not exist";
        }
        return "Review deleted Successfully";

    }

}

