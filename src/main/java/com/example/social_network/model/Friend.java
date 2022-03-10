package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int status;
    private long id_user1;
    private long id_user2;
}
