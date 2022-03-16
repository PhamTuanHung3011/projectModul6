package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @ManyToOne
    private Users user;

    @ManyToOne

    Post post;

    @ManyToOne
    Comment comment;

}
