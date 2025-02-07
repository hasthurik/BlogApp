package com.example.BlogApp.controllers;

import com.example.BlogApp.Service.CommentService;
import com.example.BlogApp.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles/{id}/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping()
    public ResponseEntity<List<Comments>> commentsByIdArticle(@PathVariable int id) {
        return new ResponseEntity<>(commentService.findCommentsByAtricleID(id), HttpStatus.OK);
    }


}
