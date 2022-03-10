package com.example.social_network.service;

import com.example.social_network.model.Friend;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IFriendService {
    List<Friend> findAll();
    void save(Friend friend);
    void delete(Long id);
    Friend findById(Long id);
//    List<Friend> findAll();
List<Friend> getListFriendRequest(  Long id);
}
