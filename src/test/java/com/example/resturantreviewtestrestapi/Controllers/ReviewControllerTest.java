package com.example.resturantreviewtestrestapi.Controllers;

import com.example.resturantreviewtestrestapi.controllers.RestaurantController;
import com.example.resturantreviewtestrestapi.controllers.ReviewController;
import com.example.resturantreviewtestrestapi.model.ReviewModel;
import com.example.resturantreviewtestrestapi.service.ReviewService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
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
        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setReviewId(1l);
        reviewModel.setReviewerName("roopa");
        reviewModel.setRating(4);
        reviewModel.setRestaurentId(101l);
        doReturn(reviewModel).when(reviewService).createReview(reviewModel);
        ResponseEntity<ReviewModel> actualReviewModel = reviewController.createReview(reviewModel);
        ReviewModel actualReviewModel1 = actualReviewModel.getBody();
        org.junit.Assert.assertEquals(actualReviewModel1.getReviewId(),reviewModel.getReviewId());
        Assert.assertEquals(actualReviewModel1.getReviewerName(),reviewModel.getReviewerName());
        Assert.assertEquals(actualReviewModel1.getRating(),reviewModel.getRating());
        Assert.assertEquals(actualReviewModel1.getRestaurentId(),reviewModel.getRestaurentId());
    }
    @Test
    public void getAllReviews_Test(){
        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setReviewId(1l);
        reviewModel.setReviewerName("roopa");
        reviewModel.setRating(4);
        reviewModel.setRestaurentId(101l);

        ReviewModel reviewModel1 = new ReviewModel();
        reviewModel1.setReviewId(2l);
        reviewModel1.setReviewerName("roopa kumar");
        reviewModel1.setRating(4);
        reviewModel1.setRestaurentId(101l);

        List<ReviewModel> reviewModels = new ArrayList<>();
        reviewModels.add(reviewModel1);
        reviewModels.add(reviewModel);
        doReturn(reviewModel).when(reviewService).createReview(reviewModel);
        List<ReviewModel> actualReviewModel = reviewController.getAllReviews();
        for(int i =0;i<actualReviewModel.size();i++) {
            Assert.assertEquals(actualReviewModel.get(i).getReviewId(), reviewModels.get(i).getReviewId());
            Assert.assertEquals(actualReviewModel.get(i).getReviewerName(), reviewModels.get(i).getReviewerName());
            Assert.assertEquals(actualReviewModel.get(i).getRating(), reviewModels.get(i).getRating());
            Assert.assertEquals(actualReviewModel.get(i).getRestaurentId(), reviewModels.get(i).getRestaurentId());
        }
    }
}
