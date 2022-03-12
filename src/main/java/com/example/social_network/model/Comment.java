package com.example.social_network.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Array;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime date_Comment;

    @ManyToOne
    Users users;

    @ManyToOne
    Post post;


}
