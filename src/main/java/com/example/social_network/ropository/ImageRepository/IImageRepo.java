package com.example.social_network.ropository.ImageRepository;

import com.example.social_network.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepo extends JpaRepository<Image , Long> {
}
