package com.example.resturantreviewtestrestapi.controllers;
import com.example.resturantreviewtestrestapi.model.*;
import com.example.resturantreviewtestrestapi.model.Restaurant;
import com.example.resturantreviewtestrestapi.service.RestaurantService;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return service.getAllRestaurants() ;
    }
    @GetMapping("/{id}")
    public Restaurant getRestaurantbyId(@PathVariable Long id) {
        Restaurant restaurant = service.getRestaurantById(id);
        return restaurant;
    }

    //CREATE RESTAURANT
    @PostMapping("/saveRestaurentData")
    public Restaurant createRestaurant(@Validated @RequestBody Restaurant res) {
        Cuisine cuisineValue = res.getCuisine();
        // Map the cuisineValue to the Cuisine enum constant
       // Cuisine cuisine = Cuisine.fromValue(cuisineValue);
        Restaurant newRes = service.createRestaurant(res);

        List<Review> reviewList = new ArrayList<>();
        newRes.getReviews().stream().forEach(review1->{
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantId(newRes.getRestaurantId());
            review1.setRestaurant(restaurant);
            User_Info userInfo = new User_Info();
            userInfo.setUserId(res.getUser().getUserId());
            review1.setUser1(userInfo);
            reviewList.add(review1);
        });
        newRes.setReviews(reviewList);
        return service.createRestaurant(newRes);
    }

    //UPDATE RESTAURANT
    @PutMapping
    public Restaurant updateRestaurant(@RequestBody Restaurant res) {
        Restaurant toBeUpdated = service.updateRestaurant(res) ;
        return toBeUpdated;
    }

    //DELETE RESTAURANT
    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable long id) {

        boolean deleted = service.deleteRestaurant(id);
        if(!deleted) return "Restaurant not found";
        return "Restaurant deleted Successfully";

    }
}
