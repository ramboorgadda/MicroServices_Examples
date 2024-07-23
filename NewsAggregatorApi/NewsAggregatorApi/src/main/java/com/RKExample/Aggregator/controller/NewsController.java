package com.RKExample.Aggregator.controller;

import com.RKExample.Aggregator.exception.ArticleAlereadyExistsException;
import com.RKExample.Aggregator.exception.ArticleNotFoundException;
import com.RKExample.Aggregator.model.Article;
import com.RKExample.Aggregator.service.impl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PutMapping("/articles")
    public ResponseEntity<String> postAllArticles(RequestEntity<Article> articleRequestEntity){
        try {
            newsService.updateArticle(articleRequestEntity.getBody());
            return new ResponseEntity<String>("updated Successfully", HttpStatus.OK);
        } catch (ArticleNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /******************* All GET Request Mapping **************************/

    @GetMapping("/article")
    public ResponseEntity<List<Article>> getAllArticles() {

        List<Article> articles = newsService.getArticles();

        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);

    }

    @GetMapping("/article/{id}")
    public ResponseEntity<String> getArticleById(@PathVariable int id) {

        try {
            Optional<Article> article = newsService.getArticleById(id);

            return new ResponseEntity<String>(article.toString(), HttpStatus.OK);
        } catch (ArticleNotFoundException exp) {
            return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    /******************
     * All DELETE Request Mapping
     *********************************/

    @DeleteMapping("/article")
    public ResponseEntity<String> deleteArticle(RequestEntity<Integer> requestEntityId) {

        // logic to be written to delete that particular data from database
        try {
            newsService.deleteArticle(requestEntityId.getBody());
            return new ResponseEntity<String>("Deleted Succesfully" + requestEntityId.getBody(), HttpStatus.OK);
        } catch (ArticleNotFoundException exp) {
            return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable("id") int id) {

        // logic to be written to delete that particular data from database
        try {
            newsService.deleteArticle(id);
            return new ResponseEntity<String>("Deleted Succesfully" + id, HttpStatus.OK);
        } catch (ArticleNotFoundException exp) {
            return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    /********************* All POST Request Mapping *******************************/

    @PostMapping("/article")
    public  ResponseEntity<String> saveArticle(RequestEntity<Article> requestEntityArticle) {


        try {
            newsService.addArticle(requestEntityArticle.getBody());
            return new ResponseEntity<String>("Added Successfully", HttpStatus.OK);
        } catch (ArticleAlereadyExistsException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
      }

    @RequestMapping()
    public ResponseEntity<String> defaultMap() {
        return new ResponseEntity<String>("Request Not Found, Please Enter Proper Url", HttpStatus.OK);
    }
    }
