package com.example.BlogApp.Service;

import com.example.BlogApp.model.Article;
import com.example.BlogApp.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;


    public Article findArticleById(Integer id) {
        return articleRepo.findById(id).orElse(null);
    }


    public Article saveArticle(Article article) {
        return articleRepo.save(article);
    }


    public void deleteArticleById(Integer id) {
        articleRepo.deleteById(id);
    }


    public Article updateArticleById(Article article, Integer id) {
        Article editArticle = articleRepo.findById(id).orElse(null);
        assert editArticle != null;
        editArticle.setAuthor(article.getAuthor());
        editArticle.setContent(article.getContent());
        return articleRepo.save(editArticle);
    }


    public List<String> findTitle() {
        return articleRepo.findAllArticleTitle();
    }


    public ArrayList<String[]> findArticleByRequest(String title) {
        return articleRepo.findArticleByTextRequest(title);
    }
}
