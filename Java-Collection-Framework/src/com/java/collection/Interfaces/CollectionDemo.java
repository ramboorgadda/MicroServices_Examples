package com.java.collection.Interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> fruiltcollection = new ArrayList<>();
        fruiltcollection.add("Banana");
        fruiltcollection.add("apple");
        fruiltcollection.add("mango");
        System.out.println(fruiltcollection);
        fruiltcollection.remove("Banana");
        System.out.println(fruiltcollection);
        System.out.println(fruiltcollection.contains("apple"));
        fruiltcollection.forEach(s -> {
            System.out.println(s);
        });
        Iterator fruitIterator = fruiltcollection.stream().iterator();

        if(fruitIterator.hasNext()){
         System.out.println(fruitIterator.next());
        }
        fruiltcollection.clear();
        System.out.println(fruiltcollection);
    }
}
