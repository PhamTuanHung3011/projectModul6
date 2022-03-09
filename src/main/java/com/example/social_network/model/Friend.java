package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private enum status{
        CHO,
        DONGY,
        TUCHOI
    }
    @ManyToOne
    Users User1 ,User2;
}
