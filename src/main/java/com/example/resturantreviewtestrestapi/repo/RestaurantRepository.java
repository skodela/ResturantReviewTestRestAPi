package com.example.resturantreviewtestrestapi.repo;

import com.example.resturantreviewtestrestapi.model.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RestaurantRepository extends CrudRepository<RestaurantModel, Long> {
    //all crud database methods
    Optional <RestaurantRepository> findByName(String name);

}