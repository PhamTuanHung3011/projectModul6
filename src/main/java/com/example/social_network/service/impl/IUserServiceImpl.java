package com.example.social_network.service.impl;

import com.example.social_network.model.User;
import com.example.social_network.ropository.IUserRepo;
import com.example.social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    IUserRepo iUserRepo;


    @Override
    public Optional<User> findByUsername(String name) {
        return iUserRepo.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return iUserRepo.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return iUserRepo.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return iUserRepo.save(user);
    }
}
