package com.RKExample.Aggregator.exception;

public class ArticleNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
