package com.java.collection.HashSetEx;

import java.util.HashSet;
import java.util.Set;

public class CreatehashSetExample {

    public static void main(String[] args) {
        Set<String> programmingLanguages = new HashSet<>();
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("Scala");
        System.out.println(programmingLanguages);
        programmingLanguages.add("Java");
        System.out.println(programmingLanguages);

    }

}
