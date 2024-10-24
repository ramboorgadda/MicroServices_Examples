package com.java.collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementsArrayList {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("mango");
        fruits.add("grapes");
        fruits.add("banana");
        System.out.println(fruits);
       // fruits.removeIf(s -> s.startsWith("a"));
        //fruits.remove("mango");
        List<String> subfruits = new ArrayList<>();
        subfruits.add("apple");
        subfruits.add("mango");
        fruits.removeAll(subfruits);
        System.out.println(fruits);
        fruits.clear();
        System.out.println(fruits);
    }
}
