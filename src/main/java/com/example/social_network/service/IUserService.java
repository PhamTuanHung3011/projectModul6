package com.example.social_network.service;

import com.example.social_network.model.Users;

import java.util.Optional;

public interface IUserService {
    Optional<Users> findByUsername(String name);// tim kiem user co ton tai ko
    Boolean existsByUsername(String username);// kiem tra co ton tai hay ko
    Boolean existsByEmail(String email);// kiem tra email
    Users save(Users user);

    Users findUserById(Long id);
    Users findById(Long id);
}
