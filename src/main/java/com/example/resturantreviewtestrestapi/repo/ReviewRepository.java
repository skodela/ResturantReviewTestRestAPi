package com.example.resturantreviewtestrestapi.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resturantreviewtestrestapi.model.ReviewModel;
@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long>{

    Optional<ReviewModel> findById(Long id);

    List<ReviewModel> findByRestaurentId(Long restaurentId);

}