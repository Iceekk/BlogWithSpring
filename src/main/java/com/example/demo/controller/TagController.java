package com.example.demo.controller;


import com.example.demo.entity.Article;
import com.example.demo.entity.Tag;
import com.example.demo.repository.TagRepository;
import com.example.demo.viewModel.ArticleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

@Controller
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/tag/{name}")
    public String articleWithTag(Model model, @PathVariable String name){
        Tag tag = this. tagRepository.findByName(name);

        if(tag == null){
            return "redirect:/";
        }
        Set<Article> articles = tag.getArticles();
        List<ArticleViewModel> output = new ArrayList<>();

        for(Article article : articles){
            ArticleViewModel articleViewModel = new ArticleViewModel(article.getId(), article.getTitle(), Base64.getEncoder().encodeToString(article.getImage()),
                    article.getAuthor().getFullName(),
                    article.getTags(),
                    article.getSummary());

            output.add(articleViewModel);
        }

        model.addAttribute("tagName",name);
        model.addAttribute("articles", output);
        model.addAttribute("view", "tag/articles");

        return "base-layout";
    }
}
