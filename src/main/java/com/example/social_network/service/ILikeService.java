package com.example.social_network.service;

import com.example.social_network.model.Likes;

import java.util.List;

public interface ILikeService {
    List<Likes> findAll();

    Likes save(Likes like);

    void deleteById(Long id);

    Likes findById(Long id);

    Long getLikeNumber(Long id);
}
