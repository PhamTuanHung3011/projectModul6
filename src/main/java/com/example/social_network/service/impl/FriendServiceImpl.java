package com.example.social_network.service.impl;

import com.example.social_network.model.Friend;
import com.example.social_network.model.Users;
import com.example.social_network.ropository.FriendRepo;
import com.example.social_network.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void deleteById(Long id) {
        friendRepo.deleteById(id);
    }

    @Override
    public void delete(Friend friend) {
        friendRepo.delete(friend);
    }


    @Override
    public Friend findById(Long id) {
        return findById(id);
    }

    @Override
    public Friend findAllByUserSender(Long id1, Long id2) {
        return friendRepo.findAllByUserSender(id1, id2);
    }

    @Override
    public List<Friend> findAllByUserSenderOrUserReceiver(Users user1, Users user2) {
        List<Friend> list = friendRepo.findAllByUserSenderOrUserReceiver(user1, user2);
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            if (!list.get(i).isStatus()) {
                list.remove(list.get(i));
            }
        }
        return list;
    }


    @Override
    public List<Friend> findFriendsByUserReceiverAndStatusIsFalse(Users userReceiver) {
        return friendRepo.findFriendsByUserReceiverAndStatusIsFalse(userReceiver);
    }

    @Override
    public List<Users> findListFriendByUser(Users users) {
        List<Users> listUser = new ArrayList<>();
        if (users != null) {
            List<Friend> listFriend = findAllByUserSenderOrUserReceiver(users, users);
            for (Friend friend : listFriend) {
                if (friend.getUserReceiver() == users) {
                    listUser.add(friend.getUserSender());
                } else {
                    listUser.add(friend.getUserReceiver());
                }
            }
            return listUser;
        }
        return null;
    }

    @Override
    public List<Users> findAllSimilarFriend(Users user1, Users user2) {
        List<Users> usersList = new ArrayList<>();
        List<Users> listFriendUser1 = findListFriendByUser(user1);
        List<Users> listFriendUser2 = findListFriendByUser(user2);
        for (Users friend1 : listFriendUser1) {
            for (Users friend2 : listFriendUser2) {
                if (friend1 == friend2) {
                    usersList.add(friend1);
                }
            }
        }
        return usersList;
    }
}
