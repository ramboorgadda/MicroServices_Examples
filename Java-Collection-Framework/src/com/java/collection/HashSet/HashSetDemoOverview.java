package com.java.collection.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemoOverview {
    public static void main(String[] args) {
        addNullvalues();

    }

    public static void addNullvalues(){
        Set<HashSet> set = new HashSet<>();
        set.add(null);
        set.add(null);
        System.out.println(set.toString());
    }
}
