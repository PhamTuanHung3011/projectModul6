package com.example.social_network.model;

import javax.persistence.*;


@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user1_id")
    private Users userSender;
    @ManyToOne
    @JoinColumn(name = "user2_id")
    private Users userReceiver;
    private boolean status;

    public Friend() {

    }

    public Friend(Users userSender, Users userReceiver, boolean status) {
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.status = status;
    }

    public Friend(Long id, Users userSender, Users userReceiver, boolean status) {
        this.id = id;
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.status = status;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUserSender() {
        return userSender;
    }

    public void setUserSender(Users userSender) {
        this.userSender = userSender;
    }

    public Users getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(Users userReceiver) {
        this.userReceiver = userReceiver;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
