package com.example.BlogApp.repo;

import com.example.BlogApp.model.Comments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Integer> {
    List<Comments> findByArticleId(Integer id);
}
