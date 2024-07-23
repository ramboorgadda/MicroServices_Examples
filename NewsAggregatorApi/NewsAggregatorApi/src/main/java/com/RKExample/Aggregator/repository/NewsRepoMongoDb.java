package com.RKExample.Aggregator.repository;

import com.RKExample.Aggregator.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepoMongoDb extends MongoRepository<Article,Integer> {


}
