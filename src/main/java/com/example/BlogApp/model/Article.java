package com.example.BlogApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    int id;
    String nameArticle;
    String nameAuthor;
    Date datePublication;
    String comments;

}
