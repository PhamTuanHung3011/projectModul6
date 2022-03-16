package com.example.social_network.ropository;

import com.example.social_network.model.Friend;
import com.example.social_network.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepo extends JpaRepository<Friend, Long> {
    @Query(nativeQuery = true,value = "select * from friend where (user1_id =:id1 and user2_id =:id2) or (user1_id =:id2 and user2_id =:id1)")
    Friend findAllByUserSender(Long id1,Long id2);

    List<Friend> findAllByUserSenderOrUserReceiver(Users user1, Users user2);

    List<Friend> findFriendsByUserReceiverAndStatusIsFalse(Users userReceiver);
}
