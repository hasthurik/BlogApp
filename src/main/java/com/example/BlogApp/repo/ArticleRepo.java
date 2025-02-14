package com.example.BlogApp.repo;

import com.example.BlogApp.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {

    List<Article> findByPublished(boolean published);

    @Query(value = "select title from article where published = 'true'", nativeQuery = true)
    List<String> findAllArticleTitle();

    @Query (value = "select id, title, author from article where title LIKE %:title%", nativeQuery = true)
    ArrayList<String[]> findArticleByTextRequest(@Param("title") String title);
}
