package com.example.social_network.ropository;

import com.example.social_network.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepo extends JpaRepository<Likes,Long> {

    @Query(nativeQuery = true, value = "SELECT count(id) FROM socialnetwork.likes where post_id = :id")
    Long getLikeNumber(@Param(value = "id") Long id);
}
