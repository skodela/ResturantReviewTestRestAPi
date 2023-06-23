package com.example.resturantreviewtestrestapi.service;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.resturantreviewtestrestapi.model.Review;
import com.example.resturantreviewtestrestapi.repo.ReviewRepository;
@Service
public class ReviewService {


    final ReviewRepository repo;

    @Autowired
    public ReviewService(ReviewRepository repo){
        this.repo = repo;
    }

    //GET ALL
    public List<Review> getAllReviews() {
        return repo.findAll();
    }

    //FIND REVIEW BY ID
    public Review getReviewById(long id) {

        Optional<Review> foundReview = repo.findById(id);

        if(foundReview.isPresent()) return foundReview.get();

        return new Review();

    }


    //FIND REVIEW BY RATING (filtering reviews based on no of stars)
    public List<Review> getReviewsByRating(int rating) {

        List<Review> all = repo.findAll();

        List<Review> filteredReviews = all.stream()
                .filter(r -> r.getRating() == rating)
                .collect(Collectors.toList());

        return filteredReviews;

    }

    //FIND REVIEW BY USER ID
   /* public ReviewModel getReviewByUserId(long userId) {

        Optional<ReviewModel> foundReview = repo.findByUserId(userId);

        if(foundReview.isPresent()) return foundReview.get();

        return new ReviewModel();

    }*/


    //CREATE REVIEW
    public Review createReview(Review rev) {

        if(repo.existsById(rev.getReviewId())) return repo.save(rev);
        LocalDate currentDate =  LocalDate.now();
        //rev.setDateCreated(currentDate);
        return repo.save(rev);

    }

    //UPDATE REVIEW
    public Review updateReview(Review rev) {

        if(repo.existsById(rev.getReviewId())) return repo.save(rev);

        return new Review();

    }

    //DELETE REVIEW
    public boolean deleteReview(long id) {

        if(repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;

    }


}
