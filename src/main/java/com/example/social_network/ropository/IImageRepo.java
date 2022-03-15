package com.example.social_network.ropository;

import com.example.social_network.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepo extends JpaRepository<Image , Long> {
}
