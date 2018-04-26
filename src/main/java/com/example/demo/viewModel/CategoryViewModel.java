package com.example.demo.viewModel;

import com.example.demo.entity.Article;

import java.util.Set;

public class CategoryViewModel {

    private Integer id;
    private String name;
    private String image;
    private Set<Article> articles;


    public CategoryViewModel(Integer id, String name, String image, Set<Article> articles) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
