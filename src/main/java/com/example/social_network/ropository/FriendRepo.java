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

    // danh sách bạn bè kb
    @Query(nativeQuery = true, value = "select * from friend where (friend.user1_id =:User1 or friend.user2_id =:User1)  and friend.status = 1")
    public List<Friend> listAddedFriend(@Param(value = "User1") Long id1);

      // danh sách bạn bè chờ kb
    @Query(nativeQuery = true, value = "select * from friend where (friend.user1_id =:User1)  and friend.status = 0")
    public List<Friend> listWaitMakeFriend(@Param(value = "User1") Long id1);

    // danh sách bạn bè chung
    @Query(nativeQuery = true,value = "select * from users join (select bb1.id from (select friend.user2_id as id from friend where friend.user1_id =: idUser1 and friend.status = 1 union select friend.user1_id as id from friend where friend.user2_id =: idUser2 and friend.status = 1) as bb1 join (select friend.user2_id as id from friend where friend.user1_id = idUser1 and friend.status = 1 union select friend.user1_id as id from friend where friend.user2_id =: idUser2 and friend.status = 1) as bb2 on bb1.id = bb2.id) as bbc on users.id = bbc.id")
    List<Users> listMutualFriend(@Param(value = "idUser1") Long idUser1, @Param(value = "idUser2") Long idUser2);

}
