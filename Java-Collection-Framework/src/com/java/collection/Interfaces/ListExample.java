package com.java.collection.Interfaces;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("apples");
//        list.add("apples");
//        list.add("banana");
//        list.add("berry");
//        list.add(null);
//        System.out.println(list);
        list.add("element1");
        list.add("element2");
        list.add("element3");
        list.add("element5");
        list.add("element4");
        System.out.println(list);
          // Access elements from the list

        System.out.println(list.get(0));
        System.out.println(list.get(3));

        // iterate over list

        list.forEach(System.out::println);
    }
}
