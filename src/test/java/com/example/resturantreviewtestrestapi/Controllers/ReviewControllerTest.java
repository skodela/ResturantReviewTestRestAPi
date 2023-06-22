package com.example.resturantreviewtestrestapi.Controllers;

import com.example.resturantreviewtestrestapi.controllers.RestaurantController;
import com.example.resturantreviewtestrestapi.controllers.ReviewController;
import com.example.resturantreviewtestrestapi.model.Review;
import com.example.resturantreviewtestrestapi.service.ReviewService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {
    private final String STARTING_URI = "http://localhost:8080/api";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ReviewService reviewService;
    @Autowired
    ReviewController reviewController;

    @Test
    public void post_Test(){
        Review reviewModel = new Review();
        reviewModel.setReviewId(1l);
        reviewModel.setReviewerName("roopa");
        reviewModel.setRating(4);
        doReturn(reviewModel).when(reviewService).createReview(reviewModel);
     Review actualReviewModel = reviewController.createReview(reviewModel);
        Review actualReviewModel1 = actualReviewModel;
        Assertions.assertEquals(actualReviewModel1.getReviewId(),reviewModel.getReviewId());
        Assertions.assertEquals(actualReviewModel1.getReviewerName(),reviewModel.getReviewerName());
        Assertions.assertEquals(actualReviewModel1.getRating(),reviewModel.getRating());
    }
    @Test
    public void getAllReviews_Test(){
        Review reviewModel = new Review();
        reviewModel.setReviewId(1l);
        reviewModel.setReviewerName("roopa");
        reviewModel.setRating(4);

        Review reviewModel1 = new Review();
        reviewModel1.setReviewId(2l);
        reviewModel1.setReviewerName("roopa reddy");
        reviewModel1.setRating(4);


        List<Review> reviewModels = new ArrayList<>();
        reviewModels.add(reviewModel1);
        reviewModels.add(reviewModel);
        doReturn(reviewModel).when(reviewService).createReview(reviewModel);
        List<Review> actualReviewModel = reviewController.getAllReviews();
        for(int i =0;i<actualReviewModel.size();i++) {
            Assertions.assertEquals(actualReviewModel.get(i).getReviewId(), reviewModels.get(i).getReviewId());
            Assertions.assertEquals(actualReviewModel.get(i).getReviewerName(), reviewModels.get(i).getReviewerName());
            Assertions.assertEquals(actualReviewModel.get(i).getRating(), reviewModels.get(i).getRating());

        }
    }
}
