package com.example.BlogApp.controllers;

import com.example.BlogApp.Service.CommentService;
import com.example.BlogApp.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    //все комментарии по id статьи
    @GetMapping("/article/{id}/comments")
    public ResponseEntity<List<Comments>> commentsByIdArticle(@PathVariable int id) {
        return new ResponseEntity<>(commentService.findCommentsByArticleID(id), HttpStatus.OK);
    }

    //добавление нового комментария
    @PostMapping("/article/{id}/comments")
    public ResponseEntity<Comments> addComment(@PathVariable int id, @RequestBody Comments comment) {
        Comments savedComment = commentService.addComment(id, comment);
        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }
}
