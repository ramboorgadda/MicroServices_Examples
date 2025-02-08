package com.rksolutions.springbootmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.rksolutions.springbootmongodb")
@SpringBootApplication
public class SpringbootWebfluxMongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxMongodbDemoApplication.class, args);
	}

}
