package com.example.social_network.service;

import com.example.social_network.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> findAll();
    Post save(Post post);
    void delete(Long id);
    Post findById(Long id);
    List<Post> findByTimePost();
}
