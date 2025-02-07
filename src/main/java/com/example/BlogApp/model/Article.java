package com.example.BlogApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    int id;
    String title;
    String Author;
    String content;
    Date datePublication;

    @OneToMany(mappedBy = "article")
    private List<Comments> comments;
}
