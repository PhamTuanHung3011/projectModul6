package com.example.social_network.service.impl;

import com.example.social_network.model.Comment;
import com.example.social_network.ropository.CommentRepo;
import com.example.social_network.ropository.PostRepo;
import com.example.social_network.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Override
    public Iterable<Comment> findAllCommentByPostId(Long postId) {
        List<Comment> comments = (List<Comment>) commentRepo.findAllCommentByPostId(postId);
        return comments;
    }

    @Override
    public int deleteComment(Long commentId) {
        Comment comment =  commentRepo.findCommentById(commentId);
        return commentRepo.deleteComment(commentId, comment.getPostId(), comment.getUserId());
    }

    @Override
    public Comment findById(Long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public List<Comment> findByTimePost() {
        return commentRepo.findCommentToTime();
    }

    @Override
    public List<Long> findUserId(Long commentId) {
        return commentRepo.findUserId(commentId);
    }

    @Override
    public int updateComment(String content, Long commentId, Long postId) {
        return commentRepo.updateComment(content, commentId, postId);
    }

    @Override
    public String findNameUser(Long userId) {
        return commentRepo.findNameUser(userId);
    }

    @Override
    public Comment findCommentByCommentId(Long commentId) {
        return  commentRepo.findCommentById(commentId);
    }

    public Comment save(Comment comment) {
        Long userOwnerId = postRepo.findPostById(comment.getId()).getUsers().getId();

        if (userOwnerId == comment.getUserId()) {
            commentRepo.save(comment);
            return comment;
        }
        return null;
//        } else {
//            try {
//                boolean status = checkFriend(userOwnerId, comment.getUserId());
//                if (status) {
//                    commentRepo.save(comment);
//                    return comment;
//                }
//                return null;
//            } catch (Exception e) {
//                e.getMessage();
//                return null;
//            }
//
//        }
    }
}
