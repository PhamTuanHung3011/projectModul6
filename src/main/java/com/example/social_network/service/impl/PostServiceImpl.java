package com.example.social_network.service.impl;

import com.example.social_network.dto.post_img.PostImgdto;
import com.example.social_network.model.Image;
import com.example.social_network.model.Post;
import com.example.social_network.ropository.PostRepo;
import com.example.social_network.security.userprincal.UserDetailService;
import com.example.social_network.service.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findPostToTime();
    }

    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepo.findById(id);
    }

    @Override
    public List<Post> findPostByUserId(Long id) {
        return postRepo.findPostByUserId(id);
    }


}
