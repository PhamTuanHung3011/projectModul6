package com.example.social_network.ropository;

import com.example.social_network.model.Friend;
import com.example.social_network.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendRepo extends JpaRepository<Friend, Long> {
    // danh sách bạn bè chưa kb
    @Query(nativeQuery = true, value = "select * from friend where (friend.user1_id =:User1 or friend.user2_id =:User1)  and friend.status in (0,1)")
    public List<Friend> listNotAddFriend(@Param(value = "User1") Long id1);
}
