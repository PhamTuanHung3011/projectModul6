package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean isPublic;
    private String image;
    private Date time;

    @ManyToOne
    private User user;
}
