package com.example.social_network.dto.post_img;

import com.example.social_network.model.Comment;
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
    private boolean isPublic;
    private String image;
    private LocalDateTime time;
    private boolean status;
    private Users users;
    private List<Comment> comments;


    public PostImgdto(Long id, String content, boolean aPublic, String image, LocalDateTime time, boolean b, Users users) {
        this.id = id;
        this.content = content;
        this.isPublic = aPublic;
        this.image = image;
        this.time = time;
        this.status = b;
        this.users = users;

    }
}
