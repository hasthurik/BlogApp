package com.example.BlogApp.controllers;

import com.example.BlogApp.Service.ArticleService;
import com.example.BlogApp.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleByID(@PathVariable int id) {
        return new ResponseEntity<>(articleService.findArticleById(id), HttpStatus.OK);
    }

}
