package com.example.BlogApp.Service;


import com.example.BlogApp.model.Article;
import com.example.BlogApp.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;


    public Article findArticleById(int id) {
        return articleRepo.findById(id).orElse(null);
    }
}
