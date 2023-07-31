package com.example.resturantreviewtestrestapi.service;

import com.example.resturantreviewtestrestapi.model.User_Info;
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
    public List<User_Info> getAllUsers() {
        return repo.findAll();
    }

    //Find By ID
    public User_Info getUserById(long id) {

        Optional<User_Info> user = repo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return new User_Info();

    }
    //Find By username
    public User_Info getUserByUserName(String username) {

        Optional<User_Info> user = repo.findByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }
        return new User_Info();

    }
    public User_Info saveUserDetails(User_Info userInfo){
       return repo.save(userInfo);

    }
}
