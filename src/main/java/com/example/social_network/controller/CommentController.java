package com.example.social_network.controller;

import com.example.social_network.model.Comment;
import com.example.social_network.service.ICommentService;
import com.example.social_network.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/{postId}")
    @ResponseBody
    public ResponseEntity<List<Comment>> findAll(@PathVariable Long postId) {
        List<Comment> comments = (List<Comment>) commentService.findAllCommentByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Comment> create(@Valid @RequestBody Comment comment) {
       Comment cm = commentService.save(comment);
        return new ResponseEntity<>(cm, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.findById(id) , HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Long commentId) {
       int status = commentService.deleteComment(commentId);
        if (status == 1) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{postId}/edit-comment/{commentId}")
    @ResponseBody
    public ResponseEntity<Comment> edit(@PathVariable Long commentId, @PathVariable Long postId) {
        Comment comment = commentService.findCommentByCommentId(commentId);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{commentId}")
    @ResponseBody
    public ResponseEntity<Integer> updateComment(@PathVariable Long commentId,@RequestBody Comment comment) {
        Comment commentOld = commentService.findCommentByCommentId(commentId);
        if (commentOld != null) {
            int updateComment = commentService.updateComment(comment.getContent(),
                    comment.getId(),
                    comment.getPostId());
            return new ResponseEntity<>(updateComment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
