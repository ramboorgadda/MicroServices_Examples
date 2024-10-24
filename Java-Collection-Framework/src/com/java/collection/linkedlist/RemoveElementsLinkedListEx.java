package com.java.collection.linkedlist;

import java.util.LinkedList;

public class RemoveElementsLinkedListEx {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("mango");
        fruits.add("strawberry");
        fruits.add("blueberry");
        System.out.println(fruits);
        fruits.removeFirst();
        System.out.println("After removing first element " +fruits);
        fruits.removeLast();
        System.out.println("After removing last element " +fruits);
        fruits.remove(1);
        System.out.println("After removing with the index "+fruits);
        fruits.remove("banana");
        System.out.println("After removing with the object "+fruits);

    }
}
