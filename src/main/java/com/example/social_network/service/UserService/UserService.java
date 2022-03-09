package com.example.social_network.service.UserService;

import com.example.social_network.model.User;
import com.example.social_network.ropository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepo userRepo;

    @Override
    public void editUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findById(id).get();
    }
}
