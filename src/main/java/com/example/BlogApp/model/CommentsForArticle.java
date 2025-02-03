package com.example.BlogApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CommentsForArticle {

    //.
    @Id
    int id;
    String author;
    String textComm;
    Date dateComment;
}
