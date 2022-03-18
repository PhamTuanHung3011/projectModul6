package com.example.social_network.controller;

import com.example.social_network.model.Notification;
import com.example.social_network.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/Notif")
public class NotifiController {
    @Autowired
    INotificationService notificationService;

    @GetMapping("/listNotifUser/{idUser}")
    public ResponseEntity<List<Notification>> getNotif(@PathVariable Long idUser){
        return new ResponseEntity<>(notificationService.listNotification(idUser), HttpStatus.OK);
    }
}
