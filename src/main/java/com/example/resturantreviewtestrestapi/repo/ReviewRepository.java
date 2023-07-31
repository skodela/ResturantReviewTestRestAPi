package com.example.resturantreviewtestrestapi.repo;
import java.util.List;
import java.util.Optional;

import com.example.resturantreviewtestrestapi.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resturantreviewtestrestapi.model.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    Optional<Review> findById(Long id);


}