package com.example.BlogApp.repo;

import com.example.BlogApp.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {
    List<Article> findByPublished(boolean published);
}
