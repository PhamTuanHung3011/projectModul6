package com.example.social_network.service.UserService;


import com.example.social_network.model.Users;


public interface IUserService {
    void editUser(Users users);
    Users findUserById(Long id);
}
