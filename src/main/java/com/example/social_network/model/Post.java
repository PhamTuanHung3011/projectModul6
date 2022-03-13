package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String status;
    private LocalDateTime date_Post;
    private int count_Like;

    @ManyToOne
    Users users;

    public Post(Long id, String content, LocalDateTime date_post, int count_like, Users users) {
        this.id = id;
        this.content = content;
        this.date_Post = date_post;
        this.count_Like = count_like;
        this.users = users;
    }

    public Post() {

    }
}
