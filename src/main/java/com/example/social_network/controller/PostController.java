package com.example.social_network.controller;

import com.example.social_network.dto.post_img.PostImgdto;
import com.example.social_network.dto.respon.ResponMess;
import com.example.social_network.model.*;
import com.example.social_network.security.userprincal.UserDetailService;
import com.example.social_network.service.IImageService;
import com.example.social_network.service.ILikeService;
import com.example.social_network.service.impl.CommentServiceImpl;
import com.example.social_network.service.impl.IUserServiceImpl;
import com.example.social_network.service.impl.LikeServiceImpl;
import com.example.social_network.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Autowired
    LikeServiceImpl iLikeServiceImpl;

    @Autowired
    CommentServiceImpl iCommentService;


//    cần hỏi lại cách xử lý thời gian trong sql;



//    show list thì yêu cầu sắp xếp bài theo thời gian! (phục vụ trang home), trang tường nhà thiết kế sau( ý đồ xét lại list theo id user)
//    phân trang theo pagination scroll
    @GetMapping
    public List<PostImgdto> findAll() {
        List<Post> posts = postService.findAll();
        List<PostImgdto> postDtos = new ArrayList<>();
        Users user = userDetailService.getCurrentUser();
        List<Likes> likesList = iLikeServiceImpl.findAll();

        for (Post post : posts) {
            PostImgdto postDto = new PostImgdto(post);

            for (Likes like : likesList) {
                if (Objects.equals(like.getUsers().getId(), user.getId()) && Objects.equals(like.getPost().getId(), post.getId())) {
                    postDto.setStatus(false);
                }
            }

            postDto.setComments(iCommentService.findListCommentByIdPost(postDto.getPost().getId()));
            postDtos.add(postDto);
        }
        return postDtos;
    }

   @GetMapping("/findAllByUserId/{idUser}")
   public ResponseEntity <List<Post>> findPostByUserId(@PathVariable Long idUser) {
       List<Post> postListByUserId =  postService.findPostByUserId(idUser);
       return new ResponseEntity<>(postListByUserId, HttpStatus.OK);
   }




    @PostMapping("/create")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        Users user = iUserService.findById(post.getUsers().getId());
        post.setUsers(user);
        CheckDate checkDate = new CheckDate();
        post.setTime(checkDate.getTimePost());
        post.setPublic(true);
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }



    @GetMapping("/findPost/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        iCommentService.findListCommentByIdPost(postService.findById(id).get().getId());
        return new ResponseEntity<>(postService.findById(id).get(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id) {
        Post post = postService.findById(id).get();
        return new ResponseEntity<>(post, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Post post = postService.findById(id).get();
        List<Likes> likes = iLikeServiceImpl.findAll();
        List<Comment> comments = iCommentService.findAll();
        for (int i = 0; i < likes.size(); i++) {
            if(likes.get(i).getPost() == post) {
                iLikeServiceImpl.deleteById(likes.get(i).getId());
            }
        }
        for (int i = 0; i < comments.size(); i++) {
            if(comments.get(i).getPost() == post) {
                iCommentService.delete(comments.get(i).getId());
            }
        }
        postService.deleteById(id);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Post> edit(@RequestBody Post post,@PathVariable Long id) {
        Post posts = postService.findById(id).get();
        posts.setId(id);
        posts.setContent(post.getContent());
        posts.setUsers(post.getUsers());
        posts.setImage(post.getImage());
        CheckDate checkDate = new CheckDate();
        posts.setTime(checkDate.getTimePost());
        return new ResponseEntity<>(postService.save(posts), HttpStatus.OK);
    }

    @GetMapping("/getLikeNumber")
    public ResponseEntity<List<Long>> likeNumber() {
        List<PostImgdto> postDtoList = findAll();
        List<Long> listLike = new ArrayList<>();
        for (PostImgdto postDto : postDtoList) {
            listLike.add(iLikeServiceImpl.getLikeNumber(postDto.getPost().getId()));
        }
        return new ResponseEntity<>(listLike, HttpStatus.OK);
    }
    @GetMapping("/comments")
    public ResponseEntity<?> findAllComment() {
        List<PostImgdto> postList = findAll();
        List<List<Comment>> comments = new ArrayList<>();
        for (PostImgdto post : postList) {
            comments.add(iCommentService.findListCommentByIdPost(post.getPost().getId()));
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @PostMapping("/{id}/createComment")
    public ResponseEntity<?> createComment(@RequestBody Comment comment, @PathVariable Long id) {
        CheckDate checkDate = new CheckDate();
        comment.setTime(checkDate.getTimePost());
        comment.setPost(postService.findById(id).get());
        iCommentService.save(comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/deleteComment")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        iCommentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
