package com.java.collection.linkedlist;

import java.util.LinkedList;

//add()
//add(2,element)
//addFirst()
//addLast()
public class CreateLinkedListEx {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("mango");
        System.out.println("fruits in LinkedList ->"+fruits);
        fruits.add(2,"watermelon");
        System.out.println("After Adding watermelon to LinkedList "+fruits);
        fruits.addFirst("strawberry");
        System.out.println("After Adding strawberry at the First "+fruits);
        fruits.addLast("blueberry");
        System.out.println("After adding blueberry at the end"+fruits);
    }
}
