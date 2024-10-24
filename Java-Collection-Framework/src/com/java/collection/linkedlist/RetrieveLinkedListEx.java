package com.java.collection.linkedlist;

import java.util.LinkedList;

public class RetrieveLinkedListEx {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("banana");
        fruits.add("mango");
        fruits.add("blueberry");
        fruits.add("apple");

        System.out.println("Get First element " + fruits.getFirst());

        System.out.println("Get Last element " + fruits.getLast());
        System.out.println("Get at the index of element " + fruits.get(1));

        for (String str : fruits) {
            System.out.println(str);
        }
        fruits.forEach(System.out::println);

    }
}