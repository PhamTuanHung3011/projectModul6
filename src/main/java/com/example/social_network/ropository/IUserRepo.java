package com.example.social_network.ropository;

import com.example.social_network.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);// tim kiem user co ton tai ko
    Boolean existsByUsername(String username);// kiem tra co ton tai hay ko
    Boolean existsByEmail(String email);// kiem tra email
}
