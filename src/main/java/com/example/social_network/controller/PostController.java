package com.example.social_network.controller;

import com.example.social_network.model.CheckDate;
import com.example.social_network.model.Post;
import com.example.social_network.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("post")
public class PostController {
    @Autowired
    IPostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> products() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post) {
        CheckDate checkDate = new CheckDate();
        post.setDate_Post(checkDate.getTimePost());
        postService.save(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findById(id) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> edit(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        CheckDate checkDate = new CheckDate();
        post.setDate_Post(checkDate.getTimePost());
        postService.save(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
