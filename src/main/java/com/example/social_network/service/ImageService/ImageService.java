package com.example.social_network.service.ImageService;

import com.example.social_network.model.Image;
import com.example.social_network.ropository.ImageRepository.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService{
    @Autowired
    IImageRepo imageRepo;

    @Override
    public List<Image> listImg() {
        return imageRepo.findAll();
    }

    @Override
    public void saveImg(Image image) {
        imageRepo.save(image);
    }

    @Override
    public void deleteImg(Long id) {
        imageRepo.deleteById(id);
    }

    @Override
    public Image findImg(Long id) {
        return imageRepo.findById(id).get();
    }
}
