package com.example.BlogApp;

import com.example.BlogApp.Service.ArticleService;
import com.example.BlogApp.model.Article;
import com.example.BlogApp.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}
}
