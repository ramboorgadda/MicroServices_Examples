package com.RKexample.spingbatchdemo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan("com.RKexample.spingbatchdemo.config")
public class SpingbatchdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingbatchdemoApplication.class, args);
	}

}
