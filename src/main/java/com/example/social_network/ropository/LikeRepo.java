package com.example.social_network.ropository;

import com.example.social_network.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Likes,Long> {
}
