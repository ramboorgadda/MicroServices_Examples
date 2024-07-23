package com.RKExample.Aggregator.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ArticleAlereadyExistsException extends Exception{

    private static final long serialVersionUID = 1L;

    public ArticleAlereadyExistsException() {
    }

    public ArticleAlereadyExistsException(String message) {
        super(message);
    }
}
