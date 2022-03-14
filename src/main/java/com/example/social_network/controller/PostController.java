package com.example.social_network.controller;

import com.example.social_network.dto.post_img.PostImgdto;
import com.example.social_network.dto.respon.ResponMess;
import com.example.social_network.model.CheckDate;
import com.example.social_network.model.Image;
import com.example.social_network.model.Post;
import com.example.social_network.model.Users;
import com.example.social_network.security.userprincal.UserDetailService;
import com.example.social_network.service.IImageService;
import com.example.social_network.service.impl.IUserServiceImpl;
import com.example.social_network.service.impl.PostServiceImpl;
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
    PostServiceImpl postService;

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    IImageService imageService;

    @Autowired
    IUserServiceImpl iUserService;


//    cần hỏi lại cách xử lý thời gian trong sql;



//    show list thì yêu cầu sắp xếp bài theo thời gian! (phục vụ trang home), trang tường nhà thiết kế sau( ý đồ xét lại list theo id user)
//    phân trang theo pagination scroll
    @GetMapping
    public ResponseEntity<List<PostImgdto>> findAllPost() {
        List<PostImgdto> postList = postService.findByTimePost();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

   @GetMapping("/findAllByUserId/{idUser}")
   public ResponseEntity <List<PostImgdto>> findPostByUserId(@PathVariable Long idUser) {
       List<PostImgdto> postListByUserId =  postService.findPostByUserCurrentId(idUser);
       return new ResponseEntity<>(postListByUserId, HttpStatus.OK);
   }



    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostImgdto post) {

        Users users =iUserService.findUserById(post.getUsers().getId())  ;
        post.setDate_Post(CheckDate.getTimePost());
        post.setUsers(users);
        Post postNew = PostImgdto.bulldPost(post);
        postService.save(postNew);

        for (Image img: post.getListImage()) {
            img.setUsers(post.getUsers());
            img.setPost(postNew);
            imageService.saveImg(img);
        }

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
    public ResponseEntity<PostImgdto> edit(@PathVariable Long id, @RequestBody PostImgdto post_dto) {
//        Post postNew = PostImgdto.bulldPost(post_dto);
//        if (post_dto.getUsers().getId() == userDetailService.getCurrentUser().getId()) {
//
//            post_dto.setId(id);
//            CheckDate checkDate = new CheckDate();
//            post_dto.setDate_Post(checkDate.getTimePost());
//            for (int i = 0; i <postService.findAll().size() ; i++) {
//                if(postService.findAll().get(i).getId() == post_dto.getId()) {
//                    postService.save(postNew);
//                    for (Image img: post_dto.getListImage()) {
//                        img.setUsers(post_dto.getUsers());
//                        img.setPost(postNew);
//                        imageService.saveImg(img);
//                    }
//                }
//            }
//
//            System.out.println("getCurrentUser");
//            System.out.println(userDetailService.getCurrentUser());
//        }
//        else {
//            new ResponseEntity<>(new ResponMess("no"), HttpStatus.OK);
//        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
