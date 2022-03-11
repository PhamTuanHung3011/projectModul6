package com.example.social_network.dto.post_img;

import com.example.social_network.model.Image;
import com.example.social_network.model.Post;
import com.example.social_network.model.Users;
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

    static public Post bulldPost(PostImgdto post){
        return new Post(post.getId(), post.getContent(),post.getDate_Post(),post.getCount_Like(),post.getUsers());
    }
}
