package com.example.resturantreviewtestrestapi.controllers;
import com.example.resturantreviewtestrestapi.model.RestaurantModel;
import com.example.resturantreviewtestrestapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;
    @GetMapping
    public List<RestaurantModel> getAllRestaurants() {
        return service.getAllRestaurants() ;
    }
    @GetMapping("/{id}")
    public RestaurantModel getRestaurantbyId(@PathVariable Long id) {
        return service.getRestaurantById(id) ;
    }

    //CREATE RESTAURANT
    @PostMapping
    public ResponseEntity<RestaurantModel> createRestaurant(@RequestBody RestaurantModel res) {

        RestaurantModel newRes = service.createRestaurant(res);
        if(newRes.getRestaurantId()==-1L)
            return new ResponseEntity<>(newRes, HttpStatus.CONFLICT);
            return new ResponseEntity<>(newRes, HttpStatus.CREATED);
    }

    //UPDATE RESTAURANT
    @PutMapping
    public ResponseEntity<RestaurantModel> updateRestaurant(@RequestBody RestaurantModel res) {
        RestaurantModel toBeUpdated = service.updateRestaurant(res) ;
        if (toBeUpdated.getRestaurantId() == -1L)
            return new ResponseEntity<>(toBeUpdated, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(toBeUpdated, HttpStatus.OK);
    }

    //DELETE RESTAURANT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable long id) {

        boolean deleted = service.deleteRestaurant(id);
        if(!deleted) return new ResponseEntity<>("Restaurant not found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>("Restaurant deleted Successfully", HttpStatus.OK);

    }
}
