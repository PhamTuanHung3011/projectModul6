package com.example.social_network.controller;

import com.example.social_network.model.User;
import com.example.social_network.service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @PutMapping("/editUser/{id}")
    public ResponseEntity<User> editImg(@RequestBody User user, @PathVariable Long id){
        user.setId(id);
        userService.editUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
