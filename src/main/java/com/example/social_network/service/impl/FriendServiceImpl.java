package com.example.social_network.service.impl;

import com.example.social_network.model.Friend;
import com.example.social_network.ropository.FriendRepo;
import com.example.social_network.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements IFriendService {
    @Autowired
    FriendRepo friendRepo;

    @Override
    public List<Friend> findAll() {
        return friendRepo.findAll();
    }

    @Override
    public void save(Friend friend) {
        friendRepo.save(friend);
    }

    @Override
    public void delete(Long id) {
        friendRepo.deleteById(id);
    }

    @Override
    public Friend findById(Long id) {
        return findById(id);
    }

    @Override
    public List<Friend> getListFriendRequest(Long id) {
        return friendRepo.getListFriendRequest(id);
    }

}
