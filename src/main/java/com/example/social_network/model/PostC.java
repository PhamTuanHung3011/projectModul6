package com.example.social_network.model;

public class PostC {
    private  Post post;
    private Long userId;

    public PostC(Post post, Long userId) {
        this.post = post;
        this.userId = userId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
