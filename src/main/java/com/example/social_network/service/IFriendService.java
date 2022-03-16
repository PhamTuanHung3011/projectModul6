package com.example.social_network.service;

import com.example.social_network.model.Friend;
import com.example.social_network.model.Users;

import java.util.List;

public interface IFriendService {
    List<Friend> findAll();
    void save(Friend friend);
    void deleteById(Long id);
    void delete(Friend friend);
    Friend findById(Long id);
    Friend findAllByUserSender(Long id1,Long id2);

    List<Friend> findAllByUserSenderOrUserReceiver(Users user1, Users user2);

    List<Friend> findFriendsByUserReceiverAndStatusIsFalse(Users userReceiver);

    List<Users> findListFriendByUser(Users users);

    List<Users> findAllSimilarFriend (Users user1,Users user2);
}
