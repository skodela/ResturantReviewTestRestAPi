package com.example.resturantreviewtestrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.resturantreviewtestrestapi.model.UserModel;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserModel,Long> {

    Optional<UserModel> findByUsername(String username);
}