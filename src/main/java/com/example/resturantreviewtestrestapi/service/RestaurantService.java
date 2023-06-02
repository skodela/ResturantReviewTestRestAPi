package com.example.resturantreviewtestrestapi.service;

import java.util.List;
import java.util.Optional;

import com.example.resturantreviewtestrestapi.model.ReviewModel;
import com.example.resturantreviewtestrestapi.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resturantreviewtestrestapi.repo.RestaurantRepository;
import com.example.resturantreviewtestrestapi.model.RestaurantModel;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repo;
    @Autowired
    ReviewRepository reviewRepository;

    //GET ALL RESTAURANTS
    public List<RestaurantModel> getAllRestaurants() {
        return (List<RestaurantModel>) repo.findAll();
    }

    //FIND BY ID
    public RestaurantModel getRestaurantById(long id) {

        Optional<RestaurantModel> found = repo.findById(id);

        if(found.isPresent()) {
            Long Id = found.get().getRestaurantId();
            List<ReviewModel> reviewModels =  reviewRepository.findByRestaurentId(Id);
            found.get().setReviews((long) reviewModels.size());
            repo.save(found.get());
            return found.get();
        }

        return new RestaurantModel();

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
    public RestaurantModel createRestaurant(RestaurantModel res) {

    /*if(repo.existsById(res.getRestaurantId()))*/
        return repo.save(res) ;

       // return new RestaurantModel(res.getRestaurantId(),res.getName(),res.getAddress(), res.getReview_id(), res.getCuisinetype(), res.getWebsite());

}

    //UPDATE RESTAURANT
    public RestaurantModel updateRestaurant(RestaurantModel res) {
        Optional<RestaurantModel> restaurantModel =   repo.findById(res.getRestaurantId());
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
