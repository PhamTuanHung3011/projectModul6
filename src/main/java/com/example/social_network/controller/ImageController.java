package com.example.social_network.controller;

import com.example.social_network.model.Image;
import com.example.social_network.service.ImageService.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {
    @Autowired
    IImageService imageService;

    @GetMapping("/listImg")
    public ResponseEntity<List<Image>> getList(){
        return new ResponseEntity<>(imageService.listImg(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteImg/{id}")
    public void deleteImg(@PathVariable Long id){
        imageService.deleteImg(id);
    }

    @PostMapping("/createImg")
    public ResponseEntity<Image> createImg(@RequestBody Image image){
        imageService.saveImg(image);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editImg/{id}")
    public ResponseEntity<Image> editImg(@RequestBody Image image,@PathVariable Long id){
        image.setId(id);
        imageService.saveImg(image);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
