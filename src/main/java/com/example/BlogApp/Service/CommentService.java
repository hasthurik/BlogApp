package com.example.BlogApp.Service;

import com.example.BlogApp.model.Article;
import com.example.BlogApp.model.Comments;
import com.example.BlogApp.repo.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentsRepo commentsRepo;

    @Autowired
    ArticleService articleService;

    public List<Comments> findCommentsByArticleID(int id) {
        return commentsRepo.findByArticleId(id);
    }

    public Comments addComment(Integer articleId, Comments comment) {
        Article article = articleService.findArticleById(articleId);
        if (article != null) {
            comment.setArticle(article); // Устанавливаем связь со статьей
            return commentsRepo.save(comment);
        }
        return null;
    }
}
