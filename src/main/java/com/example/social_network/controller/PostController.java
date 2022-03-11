package com.example.social_network.controller;

import com.example.social_network.dto.post_img.PostImgdto;
import com.example.social_network.dto.respon.ResponMess;
import com.example.social_network.model.CheckDate;
import com.example.social_network.model.Post;
import com.example.social_network.model.Users;
import com.example.social_network.security.userprincal.UserDetailService;
import com.example.social_network.service.IPostService;
import com.example.social_network.service.IImageService;
import com.example.social_network.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("post")
public class PostController {
    @Autowired
    IPostService postService;

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    IImageService imageService;

    @Autowired
    IUserService iUserService;


//    cần hỏi lại cách xử lý thời gian trong sql;



//    show list thì yêu cầu sắp xếp bài theo thời gian! (phục vụ trang home), trang tường nhà thiết kế sau( ý đồ xét lại list theo id user)
//    phân trang theo pagination scroll
    @GetMapping
    public ResponseEntity<List<Post>> findAllPost() {
        return new ResponseEntity<>(postService.findByTimePost(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Post post, @PathVariable Long id) {
        Users users = iUserService.findUserById(id);
        post.setUsers(users);
//        for (Image img: post_imgdto.getListImage()) {
//            img.setUsers(post_imgdto.getUsers());
//            img.setPost(post);
//            imageService.saveImg(img);
//        }

        post.setDate_Post(CheckDate.getTimePost());
        postService.save(post);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findById(id) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Post post) {

        if (post.getUsers().getId() == userDetailService.getCurrentUser().getId()) {
            post.setId(id);
            CheckDate checkDate = new CheckDate();
            post.setDate_Post(checkDate.getTimePost());
            postService.save(post);
        }
        else {
            new ResponseEntity<>(new ResponMess("no"), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
