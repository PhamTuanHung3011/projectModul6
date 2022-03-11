package com.example.social_network.ropository;

import com.example.social_network.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String name);// tim kiem user co ton tai ko
    Boolean existsByUsername(String username);// kiem tra co ton tai hay ko
    Boolean existsByEmail(String email);// kiem tra email
   @Query(nativeQuery = true,value = "select * from users where name like concat ('%',:name,'%')")
    public List<Users> searchNameUser(@Param("name") String name);
}
