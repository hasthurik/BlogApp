package com.example.BlogApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    int id;
    String author;
    String content;
    Date dateComment;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;
}
