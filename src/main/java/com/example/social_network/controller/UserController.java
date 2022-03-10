package com.example.social_network.controller;

import com.example.social_network.model.User;
import com.example.social_network.service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    IUserService userService;

    @PutMapping("/editUser/{id}")
    public ResponseEntity<User> editImg(@RequestBody User user, @PathVariable Long id){
        user.setId(id);
        userService.editUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id) , HttpStatus.OK);
    }
}
