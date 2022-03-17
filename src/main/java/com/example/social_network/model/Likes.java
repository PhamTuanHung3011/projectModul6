package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Users users;
    @ManyToOne
    private Post post;
    public Likes() {

    }

    public Likes(Users users, Post post) {
        this.users = users;
        this.post = post;
    }
}
