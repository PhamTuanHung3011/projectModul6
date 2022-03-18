package com.example.social_network.ropository;

import com.example.social_network.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INotificationRepo extends JpaRepository<Notification, Long> {
    @Query(nativeQuery = true,value = "select * from notification where to_id =:idUser")
    List<Notification> getNotification (@Param(value = "idUser")Long idUser);

}
