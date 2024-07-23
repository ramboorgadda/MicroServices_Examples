package com.RKExample.Aggregator.service.impl;

import com.RKExample.Aggregator.exception.ArticleAlereadyExistsException;
import com.RKExample.Aggregator.exception.ArticleNotFoundException;
import com.RKExample.Aggregator.model.Article;
import com.RKExample.Aggregator.repository.NewsRepoMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("NewsServiceMongoImpl")
public class NewsServiceMongoImpl implements NewsService{

    @Autowired
    private NewsRepoMongoDb newsRepoMongoDb;

    @Override
    public void addArticle(Article article) throws ArticleAlereadyExistsException {
        if(newsRepoMongoDb.existsById(article.getId())){
             throw new ArticleAlereadyExistsException("Article with id"+ article.getId() + " already exists");
        }
        else
            newsRepoMongoDb.save(article);
    }

    @Override
    public void updateArticle(Article article) throws ArticleNotFoundException {

        if(newsRepoMongoDb.existsById(article.getId())){
            newsRepoMongoDb.save(article);
        }
        else
            throw new ArticleNotFoundException("Article with id"+ article.getId() + " Not Found");

    }

    @Override
    public List<Article> getArticles() {
        List<Article> articles = new ArrayList<>();
        articles.addAll(newsRepoMongoDb.findAll());
        return articles;
    }

    @Override
    public void deleteArticle(int articleId) throws ArticleNotFoundException {
         if(newsRepoMongoDb.existsById(articleId)){
             newsRepoMongoDb.deleteById(articleId);
         }
         else
         {
             throw new ArticleNotFoundException("Article with Id" + articleId + " does not exists");
         }
    }

    @Override
    public Optional<Article> getArticleById(int articleId) throws ArticleNotFoundException {
        if (newsRepoMongoDb.existsById(articleId)) {
            return newsRepoMongoDb.findById(articleId);

        } else {
            throw new ArticleNotFoundException("Article with Id" + articleId + " does not exists");
        }

    }
}
