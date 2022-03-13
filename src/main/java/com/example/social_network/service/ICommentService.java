package com.example.social_network.service;

import com.example.social_network.model.Comment;

import java.util.List;

public interface ICommentService {
    Iterable<Comment> findAllCommentByPostId(Long postId);
    int deleteComment(Long commentId);
    Comment findById(Long id);
    List<Comment> findByTimePost();
    List<Long> findUserId(Long commentId);
    int updateComment(String content, Long commentId, Long postId);
    String findNameUser(Long userId);
    Comment findCommentByCommentId(Long commentId);
}
