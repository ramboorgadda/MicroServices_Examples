package com.programmingtechie.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class ProductServiceApplicationTests {

   @Container
 	MongoDBContainer mongoDBContainer=new MongoDBContainer("mongo:4.4.2");
	@Test
	void contextLoads() {
	}

}
