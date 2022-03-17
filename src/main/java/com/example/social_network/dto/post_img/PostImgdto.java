package com.example.social_network.dto.post_img;

import com.example.social_network.model.*;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class PostImgdto {
    private Post post;
    private boolean status;
    private List<Comment> comments;
    private List<Likes> likes;

    public PostImgdto(Post post) {
        this.post = post;
    }

    public PostImgdto(Post post, boolean status) {
        this.post = post;
        this.status = status;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }
}
