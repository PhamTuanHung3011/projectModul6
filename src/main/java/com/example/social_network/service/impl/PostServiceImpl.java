package com.example.social_network.service.impl;

import com.example.social_network.model.Post;
import com.example.social_network.model.Users;
import com.example.social_network.ropository.PostRepo;
import com.example.social_network.security.userprincal.UserDetailService;
import com.example.social_network.service.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserDetailService userDetailService;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post save(Post post) {
       return postRepo.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Post findById(Long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public List<Post> findByTimePost() {
        return postRepo.findPostToTime();
    }

}
