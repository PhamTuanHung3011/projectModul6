package com.example.social_network.ropository;

import com.example.social_network.model.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM socialnetwork.comment order by date_comment DESC")
    List<Comment> findCommentToTime();

    Iterable<Comment> findAllCommentByPostId(Long post_id);

    @Query(nativeQuery = true, value = "select users_id from socialnetwork.comment where id =?")
    List<Long> findUserId(Long id);

    @Query(nativeQuery = true, value = "select name from socialnetwork.users where id =?")
    String findNameUser(Long user_id);

    Comment findCommentById(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "delete from socialnetwork.comment where id = ? and post_id = ? and users_id = ?")
    int deleteComment(Long id, Long post_id, Long user_id);

    @Modifying
    @Query(nativeQuery = true, value = "update socialnetwork.comment set content = ? where id = ? and post_id = ?")
    int updateComment(String content, Long id, Long post_id);
}
