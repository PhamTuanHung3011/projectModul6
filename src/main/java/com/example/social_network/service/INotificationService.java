package com.example.social_network.service;

import com.example.social_network.model.Notification;

import java.util.List;

public interface INotificationService {
    List<Notification> listNotification();
    void createNotifSender(Long idUser1,Long idUser2);
    void createNotifReceive(Long idUser1,Long idUser2);
    void deleteNotification(Long id);

}
