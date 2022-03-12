package com.example.social_network.controller;

import com.example.social_network.model.CheckDate;
import com.example.social_network.model.Comment;
import com.example.social_network.model.Post;
import com.example.social_network.model.Users;
import com.example.social_network.service.ICommentService;
import com.example.social_network.service.IPostService;
import com.example.social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    ICommentService commentService;

    @Autowired
    IUserService iUserService;

    @Autowired
    IPostService iPostService;

    @GetMapping
    public ResponseEntity<List<Comment>> products() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        Users users = iUserService.findUserById(comment.getUsers().getId());
        Post post = iPostService.findById(comment.getPost().getId());
        comment.setDate_Comment(CheckDate.getTimePost());
        comment.setUsers(users);
        comment.setPost(post);
        commentService.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.findById(id) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        commentService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> edit(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setId(id);
        commentService.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
