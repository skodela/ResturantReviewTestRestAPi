package com.example.resturantreviewtestrestapi.repo;

import com.example.resturantreviewtestrestapi.model.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User_Info,Long> {

    Optional<User_Info> findByUsername(String username);
}