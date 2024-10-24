package com.java.collection.HashSetEx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DifferentWaysToIterate {

    public static void main(String[] args) {

        Set<String> courses = new HashSet<>();
        courses.add("C");
        courses.add("C++");
        courses.add("Java");
        courses.add("Python");
        courses.add("Scala");

        for(String cource : courses){
            System.out.println(cource);
        }
         System.out.println("----------------");
        for(Iterator<String> iterator = courses.iterator(); iterator.hasNext();){
           String course = (String)iterator.next();
            System.out.println(course);
        }
        System.out.println("----------------");
        Iterator<String> iterator = courses.iterator();
        while((iterator.hasNext())){
            String type = (String)iterator.next();
            System.out.println(type);
        }
        System.out.println("----------------");
        courses.forEach(cource -> System.out.println(cource));
        System.out.println("----------------");
        courses.stream().filter(cource -> !"Java".equals(cource)).forEach(System.out::println);
    }


}
