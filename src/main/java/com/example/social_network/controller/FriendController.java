package com.example.social_network.controller;

import com.example.social_network.model.Friend;
import com.example.social_network.model.Users;
import com.example.social_network.ropository.FriendRepo;
import com.example.social_network.service.IFriendService;
import com.example.social_network.service.IUserService;
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
    @Autowired
    IUserService userService;

    @GetMapping
    public ResponseEntity<List<Friend>> getAll() {
        return new ResponseEntity<>(friendService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Friend> create(@RequestBody Friend friend) {
        friend.setStatus(false);
        friendService.save(friend);
        return new ResponseEntity<>(friend, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Friend> findById(@PathVariable Long id) {
        return new ResponseEntity<>(friendService.findById(id) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        friendService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Friend> acceptFriend(@PathVariable Long id, @RequestBody Friend friend) {
        friend.setId(id);
        friendService.save(friend);
        return new ResponseEntity<>(friend, HttpStatus.OK);
    }

    @GetMapping("/listfriend/{id}")
    public ResponseEntity<List<Users>> showListFriend(@PathVariable Long id){
        Users users = userService.findById(id);
        return (ResponseEntity<List<Users>>) friendService.findListFriendByUser(users);
    }

    @GetMapping("/listsimilarfriend/{id1}/{id2}")
    public ResponseEntity<List<Users>> findAllSimilarFriend(@PathVariable Long id1,@PathVariable Long id2){
        Users user1 = userService.findById(id1);
        Users user2 = userService.findById(id2);
        return (ResponseEntity<List<Users>>) friendService.findAllSimilarFriend(user1,user2);
    }
}
