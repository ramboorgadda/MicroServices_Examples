package com.RKExample.Aggregator.service.impl;

import com.RKExample.Aggregator.exception.ArticleAlereadyExistsException;
import com.RKExample.Aggregator.exception.ArticleNotFoundException;
import com.RKExample.Aggregator.model.Article;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    void addArticle(Article article) throws ArticleAlereadyExistsException;
    void updateArticle(Article article) throws ArticleNotFoundException;
    List<Article> getArticles();
    void deleteArticle(int articleId) throws ArticleNotFoundException;
    Optional<Article> getArticleById(int articleId) throws ArticleNotFoundException;
}
