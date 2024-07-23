package com.RKExample.Aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class NewsAggregatorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsAggregatorApiApplication.class, args);
	}

}
