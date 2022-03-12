package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Like_Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //thay vì đếm count_like, thì mình để stt là 0 hoặc 1 để đánh dấu like hay chưa.
    private boolean status;
    private int count_Like;


    @ManyToOne
    Users users;

    @ManyToOne
    Post post;
}
