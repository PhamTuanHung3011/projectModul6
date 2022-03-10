package com.example.social_network.controller;

import com.example.social_network.model.Users;
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
    public ResponseEntity<Users> editUser(@RequestBody Users users, @PathVariable Long id){
        users.setId(id);
        userService.editUser(users);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id) , HttpStatus.OK);
    }
}
