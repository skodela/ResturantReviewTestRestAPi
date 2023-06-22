package com.example.resturantreviewtestrestapi.controllers;

import com.example.resturantreviewtestrestapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.resturantreviewtestrestapi.service.UserService;

@RequestMapping("/api")
@RestController
    public class UserController {

    @Autowired
      private   UserService service;

        //Find By username
        @GetMapping("/UserModel/username/{username}")
        @CrossOrigin(origins = "http://localhost:8080")
        //This is from David's security implementation, uncomment it to try it out!
//	@PreAuthorize("#username == authentication.name")
        public User  getUserByUserName(@PathVariable("username") String username) {
            return service.getUserByUserName(username) ;
        }

    }
