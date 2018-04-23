package com.example.demo.viewModel;

import com.example.demo.entity.Tag;

import java.util.Set;

public class ArticleViewModel {
    private Integer articleId;
    private String title;
    private String image;
    private String authorName;
    private Set<Tag> tags;

    private String articleSummary;

    public ArticleViewModel(Integer articleId, String title, String image, String authorName, Set<Tag> tags,String articleSummary) {
        this.articleId = articleId;
        this.title = title;
        this.image = image;
        this.authorName = authorName;
        this.tags = tags;


        this.articleSummary = articleSummary;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    //

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }
}
