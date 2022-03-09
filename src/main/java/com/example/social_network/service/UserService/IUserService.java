package com.example.social_network.service.UserService;

import com.example.social_network.model.User;

import java.util.List;

public interface IUserService {
    void editUser(User user);
    User findUserById(Long id);
}
