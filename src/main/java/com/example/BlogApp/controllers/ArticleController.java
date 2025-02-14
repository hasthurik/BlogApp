package com.example.BlogApp.controllers;

import com.example.BlogApp.Service.ArticleService;
import com.example.BlogApp.model.Article;
import com.example.BlogApp.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleRepo articleRepo;

    //Получение всех опубликованных статей
    @GetMapping("/published")
    public ResponseEntity<List<Article>> getPublishedArticles() {
        List<Article> articles = articleRepo.findByPublished(true);

        if (articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    //получение статьи по id
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleByID(@PathVariable Integer id) {
        Article article = articleService.findArticleById(id);
        if (article == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(articleService.findArticleById(id), HttpStatus.OK);
        }
    }

    //создание(добавление) новой статьи
    @PostMapping("/create")
    public ResponseEntity<Article> postArticle(@RequestBody Article article) {
        return new ResponseEntity<>(articleService.saveArticle(article), HttpStatus.CREATED);
    }

    //Удаление статьи по id
    @DeleteMapping("/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Integer id) {
        Article article = articleService.findArticleById(id);
        if (article == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            articleService.deleteArticleById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //обновление статьи
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Integer id, @RequestBody Article article) {

        Article article1 = articleService.findArticleById(id);
        if (article1 == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(articleService.updateArticleById(article, id), HttpStatus.OK);
    }

    //получение всех заголовков опубликованных стетей (нативный запрос)
    @GetMapping("/all")
    public ResponseEntity<List<String>> findAllArticleTitle() {
        return new ResponseEntity<>(articleService.findTitle(), HttpStatus.OK);
    }

    //
    @GetMapping("/search")
    public ResponseEntity<ArrayList<String[]>> findArticle(@RequestParam String title) {
        if (articleService.findArticleByRequest(title).isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(articleService.findArticleByRequest(title), HttpStatus.OK);
    }
}
