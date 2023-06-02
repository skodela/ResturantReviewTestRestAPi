package com.example.resturantreviewtestrestapi.service;

import com.example.resturantreviewtestrestapi.model.UserModel ;
import com.example.resturantreviewtestrestapi.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    //Get All Users
    public List<UserModel> getAllUsers() {
        return repo.findAll();
    }

    //Find By ID
    public UserModel getUserById(long id) {

        Optional<UserModel> user = repo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return new UserModel();

    }
    //Find By username
    public UserModel getUserByUserName(String username) {

        Optional<UserModel> user = repo.findByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }
        return new UserModel();

    }
}
