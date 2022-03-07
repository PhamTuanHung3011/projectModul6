package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isLike;
    @OneToOne
    private User user;

    @ManyToOne
    private Post post;

}
