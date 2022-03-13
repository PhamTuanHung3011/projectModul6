package com.example.social_network.dto.post_img;

import com.example.social_network.model.*;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class PostImgdto {
    private Long id;
    private String content;
    private enum status{
        EVERYONE,
        ONLYME,
        FRIENDS
    }
    private LocalDateTime date_Post;
    private int count_Like;

    Users users;



    List<Image> listImage;
    List<Comment> listComment;

    static public Post bulldPost(PostImgdto post){
        return new Post(post.getId(), post.getContent(),post.getDate_Post(),post.getCount_Like(),post.getUsers());
    }

    public PostImgdto(Long id, String content, LocalDateTime date_Post, int count_Like, Users users, List<Image> listImage) {
        this.id = id;
        this.content = content;
        this.date_Post = date_Post;
        this.count_Like = count_Like;
        this.users = users;
        this.listImage = listImage;
    }

//    public PostImgdto(Long id, String content, LocalDateTime date_Post, int count_Like, Users users, List<Image> listImage, List<Comment> listComment) {
//        this.id = id;
//        this.content = content;
//        this.date_Post = date_Post;
//        this.count_Like = count_Like;
//        this.users = users;
//        this.listImage = listImage;
//        this.listComment = listComment;
//    }
}
