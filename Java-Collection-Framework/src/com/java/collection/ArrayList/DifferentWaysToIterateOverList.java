package com.java.collection.ArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DifferentWaysToIterateOverList {

    public static void main(String[] args) {
        List<String> courses = Arrays.asList("C","C++","Java","Python","C#");


        for(String cource : courses){
            System.out.println(cource);
        }
        //basic loop with iterator

        for (Iterator iterator = courses.iterator();iterator.hasNext();){
            String cource = (String) iterator.next();
            System.out.println(cource);
        }


    }
}
