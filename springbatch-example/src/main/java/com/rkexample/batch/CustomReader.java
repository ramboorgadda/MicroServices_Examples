package com.rkexample.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CustomReader implements ItemReader<String> {
    private String[] tokens = { "Java", "Spring", "SpringBoot", "Hibernate", "SpringBootBatch", "Advanced Java" };

    private int index =0;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
       if(index >= tokens.length) {
           return null;
       }
       String data = index + " " + tokens[index];
       index++;

       System.out.println("Reading data - "+data);

       return data;
    }
}
