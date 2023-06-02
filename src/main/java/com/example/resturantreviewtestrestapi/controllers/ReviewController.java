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

import com.example.resturantreviewtestrestapi.model.ReviewModel ;
import com.example.resturantreviewtestrestapi.service.ReviewService;

@RequestMapping("/api")
@RestController
public class ReviewController {

    @Autowired
    ReviewService service;

    //GET ALL REVIEWS
    @GetMapping("/review")
    public List<ReviewModel> getAllReviews() {
        return service.getAllReviews();
    }

    //FIND REVIEW BY ID
    @GetMapping("/review/{id}")
    public ReviewModel getReviewById(@PathVariable long id) {
        return service.getReviewById(id);
    }

    //FIND REVIEW BY RATING (filtering reviews based on no of stars)
    @GetMapping("/review/rating/{rating}")
    public List<ReviewModel> getReviewsByRating(@PathVariable int rating) {
        return service.getReviewsByRating(rating);
    }

    //CREATE REVIEW
    @PostMapping("/review/add")
    public ResponseEntity<ReviewModel> createReview(@RequestBody ReviewModel rev) {

        ReviewModel newRev = service.createReview(rev);

        if(newRev.getReviewId()==-1L) {
            return new ResponseEntity<>(newRev, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(newRev, HttpStatus.CREATED);
    }

    //UPDATE REVIEW
    @PutMapping("/review/update")
    public ResponseEntity<ReviewModel> updateReview(@RequestBody ReviewModel rev) {

        ReviewModel toBeUpdated = service.updateReview(rev);

        if(toBeUpdated.getReviewId()==-1L) {
            return new ResponseEntity<>(toBeUpdated, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toBeUpdated, HttpStatus.OK);
    }

    //DELETE REVIEW
    @DeleteMapping("/review/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> deleteReview(@PathVariable long id) {

        boolean deleted = service.deleteReview(id);

        if(!deleted) {
            return new ResponseEntity<>("This review does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Review deleted Successfully", HttpStatus.OK);

    }

}

