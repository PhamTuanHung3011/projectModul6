package com.example.social_network.service;

import com.example.social_network.model.Users;

import java.util.List;

import com.example.social_network.model.Likes;

import java.util.List;

public interface ILikeService {
    List<Users> listLikePost(Long idPost);
    List<Users> listLikeComment(Long idComment);
    Long countLikePost(Long idPost);
    Long countLikeComment(Long Comment);
    void createLikePost(Long idUser,Long idPost);
    void createLikeComment(Long idUser,Long idComment);
    void deleteLike(Long idLike);
    List<Likes> findAll();

    Likes save(Likes like);

    void deleteById(Long id);

    Likes findById(Long id);

    Long getLikeNumber(Long id);
}
