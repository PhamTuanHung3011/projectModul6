package com.example.social_network.dto.post_img;

import com.example.social_network.model.Users;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class PostDto {
    private Long id;
    private String content;
    private String status;
    private String image;
    private LocalDateTime time;
    private Users users;

    public PostDto() {
    }

    public PostDto(Long id, String content, String status, String image, LocalDateTime time, Users users) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.image = image;
        this.time = time;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
