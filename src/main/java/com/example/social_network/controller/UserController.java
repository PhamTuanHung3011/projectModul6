package com.example.social_network.controller;

import com.example.social_network.model.Users;
import com.example.social_network.service.impl.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserServiceImpl iUserService;

    @PutMapping("/editUser/{id}")
    public ResponseEntity<Users> editUser(@RequestBody Users users, @PathVariable Long id){
        users.setId(id);
        iUserService.save(users);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iUserService.findUserById(id) , HttpStatus.OK);
    }
}