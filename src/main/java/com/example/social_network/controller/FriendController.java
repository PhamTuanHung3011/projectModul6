package com.example.social_network.controller;

import com.example.social_network.model.Friend;
import com.example.social_network.model.Users;
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

//    @GetMapping
//    public ResponseEntity<List<Friend>> products() {
//        return new ResponseEntity<>(friendService.findAll(), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Friend> create(@RequestBody Friend friend) {
//        friendService.save(friend);
//        return new ResponseEntity<>(friend, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Friend> findById(@PathVariable Long id) {
//        return new ResponseEntity<>(friendService.findById(id) , HttpStatus.OK);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Friend> edit(@PathVariable Long id, @RequestBody Friend friend) {
//        friend.setId(id);
//        friendService.save(friend);
//        return new ResponseEntity<>(friend, HttpStatus.OK);
//    }

    // chức năng kết bạn

    // xem danh sách bạn bè chưa kb
    @GetMapping("/notAddFriend/{idUser}")
    public ResponseEntity<List<Users>> notAddFriend(@PathVariable Long idUser) {
        return new ResponseEntity<>(friendService.getListNotAddFriend(idUser),HttpStatus.OK);
    }

    // xem danh sách bạn bè chờ kb
    @GetMapping("/listWaitMakeFriend/{idUser}")
    public ResponseEntity<List<Friend>> listWaitMakeFriend(@PathVariable Long idUser) {
        return new ResponseEntity<>(friendService.getListWaitMakeFriend(idUser),HttpStatus.OK);
    }

    // hủy yêu cầu kb và hủy kb
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        friendService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    // xem danh sách bạn bè đã kb
    @GetMapping("/addedFriend/{idUser}")
    public ResponseEntity<List<Friend>> addedFriend(@PathVariable Long idUser){
        return new ResponseEntity<>(friendService.getListWaitMakeFriend(idUser),HttpStatus.OK);
    }

    // gửi yêu cầu kb
    @GetMapping("/waitMakeFriend/{idUser1}/{idUser2}")
    public ResponseEntity<Friend> waitMakeFriend(@PathVariable Long idUser1 ,@PathVariable Long idUser2){
        friendService.save(idUser1,idUser2);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // đồng ý kb
    @PutMapping("/agreeMakeFriend/{id}")
    public ResponseEntity<Friend> agreeMakeFriend(@PathVariable Long id, @RequestBody Friend friend) {
        friend.setId(id);
        friend.setStatus(true);
        friendService.save(friend);
        return new ResponseEntity<>(friend, HttpStatus.OK);
    }

    // xem danh sách các bạn bè chung
    @GetMapping("/listMutualFriends/{idUser1}/{idUser2}")
    public ResponseEntity<List<Friend>> listMutualFriends(@PathVariable Long idUser1,@PathVariable Long idUser2){
        friendService.listMutualFriend(idUser1,idUser2);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
