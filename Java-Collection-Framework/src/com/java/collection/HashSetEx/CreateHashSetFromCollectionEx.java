package com.java.collection.HashSetEx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateHashSetFromCollectionEx {
    public static void main(String[] args) {
       // Set<Integer> firstFiveEvenNumber = new HashSet<>();
        List<Integer> firstFiveEvenNumber = new ArrayList<>();
        firstFiveEvenNumber.add(2);
        firstFiveEvenNumber.add(4);
        firstFiveEvenNumber.add(6);
        firstFiveEvenNumber.add(8);
        firstFiveEvenNumber.add(10);
       // Set<Integer> tenEvenNumbers = new HashSet<>(firstFiveEvenNumber);
        List<Integer> tenEvenNumbers = new ArrayList<>(firstFiveEvenNumber);
        System.out.println(tenEvenNumbers);

        //Set<Integer> nextFiveEvenNumbers = new HashSet<>();
        List<Integer> nextFiveEvenNumbers = new ArrayList<>();
        nextFiveEvenNumbers.add(12);
        nextFiveEvenNumbers.add(14);
        nextFiveEvenNumbers.add(16);
        nextFiveEvenNumbers.add(18);
        nextFiveEvenNumbers.add(20);
        tenEvenNumbers.addAll(nextFiveEvenNumbers);
        System.out.println(tenEvenNumbers);
    }
}
