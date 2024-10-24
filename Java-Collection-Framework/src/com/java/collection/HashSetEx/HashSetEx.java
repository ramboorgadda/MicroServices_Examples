package com.java.collection.HashSetEx;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        printNullSet();
        printDuplicateSet();
        unOrderDemo();
    }

    public static void printNullSet(){
        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        System.out.println(set.size());
        System.out.println(set.toString());
    }
    public static void printDuplicateSet(){
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("a");
        System.out.println(set.size());
        System.out.println(set.toString());
    }
    public static void unOrderDemo(){
        Set<String> set = new HashSet<>();
        set.add("element1");
        set.add("element2");
        set.add("element7");
        set.add("element5");
        set.add("element4");
        set.add("element10");
        System.out.println(set.size());
        System.out.println(set.toString());
    }
}
