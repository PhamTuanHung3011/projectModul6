package com.example.social_network.ropository;

import com.example.social_network.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FriendRepo extends JpaRepository<Friend, Long> {
    @Query(value = "select f from Friend f where f.id_user2 = :id and f.status = 1")
     List<Friend> getListFriendRequest(@Param("id") Long id);
//    @Query(value = "select u from Users  u join Friend f on u.id = f.id_user1 ")
}