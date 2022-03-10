package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;



    private enum status{
        EVERYONE,
        ONLYME,
        FRIENDS
    }
    private LocalDateTime date_Post;
    private int count_Like;

    @ManyToOne
    Users users;

    public Post() {
    }

    public Post(Long id, String content, LocalDateTime date_Post, int count_Like, Users users) {
        this.id = id;
        this.content = content;
        this.date_Post = date_Post;
        this.count_Like = count_Like;
        this.users = users;
    }
}
