package com.example.social_network.ropository;

import com.example.social_network.model.Comment;
import com.example.social_network.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM socialnetwork.comment order by date_comment DESC")
    List<Comment> findCommentToTime();
}
