package com.example.demo.controller;


import com.example.demo.entity.Article;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.viewModel.ArticleViewModel;
import com.example.demo.viewModel.CategoryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/")
    public String index(Model model){

        List<Category> categories = this.categoryRepository.findAll();

        List<CategoryViewModel> output = new ArrayList<>();

        for (Category category : categories) {
            CategoryViewModel categoryViewModel = new CategoryViewModel(
                    category.getId(),
                    category.getName(),
                    Base64.getEncoder().encodeToString(category.getImage()),
                    category.getArticles());

            output.add(categoryViewModel);
        }

        model.addAttribute("categories", output);
        model.addAttribute("view", "home/index");


        return "base-layout";
    }

    @RequestMapping("/error/403")
    public  String accessDenied(Model model){
        model.addAttribute("view", "error/403");

        return "base-layout";
    }

    @GetMapping("/category/{id}")
    public String listArticles(Model model, @PathVariable Integer id){
        if (!this.categoryRepository.exists(id)){
            return "redirect:/";
        }

        Category category = this.categoryRepository.findOne(id);
        Set<Article> articles = category.getArticles();

        List<ArticleViewModel> output = new ArrayList<>();

        for(Article article : articles){
            ArticleViewModel articleViewModel = new ArticleViewModel(article.getId(), article.getTitle(),
                    Base64.getEncoder().encodeToString(article.getImage()),
                    article.getAuthor().getFullName(),
                    article.getTags(),
                    article.getSummary());

            output.add(articleViewModel);
        }

        model.addAttribute("articles", output);
        model.addAttribute("categoryName", category.getName());
        model.addAttribute("view", "home/list-articles");

        return "base-layout";
    }

}
