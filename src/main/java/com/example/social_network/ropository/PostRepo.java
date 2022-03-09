package com.example.social_network.ropository;

import com.example.social_network.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM socialnetwork.post order by date_post DESC")
    List<Post> findPostToTime();

}
