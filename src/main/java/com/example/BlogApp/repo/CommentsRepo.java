package com.example.BlogApp.repo;

import com.example.BlogApp.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Integer> {
}
