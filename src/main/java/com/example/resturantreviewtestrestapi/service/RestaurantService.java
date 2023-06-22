package com.example.resturantreviewtestrestapi.service;

import java.util.List;
import java.util.Optional;

import com.example.resturantreviewtestrestapi.model.Restaurant;
import com.example.resturantreviewtestrestapi.model.Review;
import com.example.resturantreviewtestrestapi.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resturantreviewtestrestapi.repo.RestaurantRepository;
import com.example.resturantreviewtestrestapi.model.Restaurant;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repo;
    @Autowired
    ReviewRepository reviewRepository;

    //GET ALL RESTAURANTS
    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) repo.findAll();
    }

    //FIND BY ID
    public Restaurant getRestaurantById(long id) {

        Optional<Restaurant> found = repo.findById(id);

        if(found.isPresent()) {
          Long Id = found.get().getRestaurantId();
            /*  List<Review> reviews = found.get().getReviews();
            found.get().setReviews(reviews);
            repo.save(found.get());*/
            return found.get();
        }

        return new Restaurant();

    }
//    //FIND BY NAME
//    public RestaurantModel getRestaurantByName(String name) {
//
//       Optional<RestaurantModel> found = repo.findByName(name);
//
//        if(found.isPresent()) return found.get();
//
//        return new RestaurantModel();
//
//    }
   //CREATE RESTAURANT
    public Restaurant createRestaurant(Restaurant res) {

    /*if(repo.existsById(res.getRestaurantId()))*/
        return repo.save(res) ;

       // return new RestaurantModel(res.getRestaurantId(),res.getName(),res.getAddress(), res.getReview_id(), res.getCuisinetype(), res.getWebsite());

}

    //UPDATE RESTAURANT
    public Restaurant updateRestaurant(Restaurant res) {
        Optional<Restaurant> restaurantModel =   repo.findById(res.getRestaurantId());
        if(restaurantModel.isPresent()){
            return  repo.save(res);
        }
        else {
            return repo.save(res);
        }
    /*    if(repo.existsById(res.getRestaurantId())) return repo.save(res);

        return new RestaurantModel(res.getRestaurantId(),res.getName(),res.getAddress(), res.getReview_id(), res.getCuisinetype(), res.getWebsite());*/

    }
    //DELETE RESTAURANT
    public boolean deleteRestaurant(long id) {

        if(repo.existsById((id))) {
            repo.deleteById(id);
            return true;
        }

        return false;

    }
}
