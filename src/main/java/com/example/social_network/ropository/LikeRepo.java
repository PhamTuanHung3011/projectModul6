package com.example.social_network.ropository;

import com.example.social_network.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like, Long> {
    //Xem số lượng like cmt
    //Like cmt người khác
    // Hủy like cmt của ng khác
    //Nhìn được số lượng like
    //Hủy like Post của người khác
    //Like Post người khác
}
