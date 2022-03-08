package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

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
    private Date date_Post;
    private int count_Like;

    @ManyToOne
    Users users;

    @ManyToOne
    Comment comment;
}
