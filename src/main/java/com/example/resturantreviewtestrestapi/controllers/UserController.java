package com.example.resturantreviewtestrestapi.controllers;
import com.example.resturantreviewtestrestapi.model.User_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.resturantreviewtestrestapi.service.UserService;

import java.util.List;

@RequestMapping("/api")
@RestController
    public class UserController {

    @Autowired
      private UserService userService;

        //Find By username
        @GetMapping("/UserModel/username/{username}")
        @CrossOrigin(origins = "http://localhost:8080")
        //This is from David's security implementation, uncomment it to try it out!
//	@PreAuthorize("#username == authentication.name")
        public User_Info getUserByUserName(@PathVariable("username") String username) {
            return userService.getUserByUserName(username) ;
        }

    @GetMapping("/getdata/{username}")
    public User_Info getUserDetails(@PathVariable("username") String username) {
        return userService.getUserByUserName(username);
    }

    @PostMapping("/addUserDatails")
    public User_Info postUserDetails(User_Info userInfo){
        return  userService.saveUserDetails(userInfo);
    }

    @GetMapping("/allUserDetails")
    public List<User_Info> getAllUsers(){
            return userService.getAllUsers();
    }

    }
