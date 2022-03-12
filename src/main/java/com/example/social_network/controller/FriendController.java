package com.example.social_network.controller;

import com.example.social_network.model.Friend;
import com.example.social_network.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Friend")
public class FriendController {
    @Autowired
    IFriendService friendService;

    @GetMapping
    public ResponseEntity<List<Friend>> products() {
        return new ResponseEntity<>(friendService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Friend> create(@RequestBody Friend friend) {

        friendService.save(friend);
        return new ResponseEntity<>(friend, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Friend> findById(@PathVariable Long id) {
        return new ResponseEntity<>(friendService.findById(id) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        friendService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Friend> edit(@PathVariable Long id, @RequestBody Friend friend) {
        friend.setId(id);
        friendService.save(friend);
        return new ResponseEntity<>(friend, HttpStatus.OK);
    }
}
