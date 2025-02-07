package com.example.BlogApp.Service;

import com.example.BlogApp.model.Comments;
import com.example.BlogApp.repo.CommentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    CommentsRepo commentsRepo;

    public List<Comments> findCommentsByAtricleID(int id) {
        return commentsRepo.findByArticleId(id);
    }
}
