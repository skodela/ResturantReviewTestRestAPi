package com.example.resturantreviewtestrestapi.service;

import com.example.resturantreviewtestrestapi.model.User ;
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
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    //Find By ID
    public User getUserById(long id) {

        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return new User();

    }
    //Find By username
    public User getUserByUserName(String username) {

        Optional<User> user = repo.findByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }
        return new User();

    }
}
