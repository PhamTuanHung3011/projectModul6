package com.example.social_network.service;

import com.example.social_network.model.Comment;
import com.example.social_network.model.Post;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void save(Comment comment);
    void delete(Long id);
    Comment findById(Long id);
    List<Comment> findByTimePost();
}
