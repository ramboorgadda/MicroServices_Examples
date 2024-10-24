package com.java.collection.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListSearchIteratorEx {
    public static void main(String[] args) {
        LinkedList<String> progLangs = new LinkedList<>();
        progLangs.add("C");
        progLangs.add("C++");
        progLangs.add("Core Java");
        progLangs.add("Java EE");
        progLangs.add("Spring Framework");
        progLangs.add("Spring Framework");
        progLangs.add("Hibernate Framework");

        boolean  result = progLangs.contains("C");

        System.out.println("Result "+result);
       int index= progLangs.indexOf("Core Java");

       //iterator



       System.out.println("Core Java Index "+index);

       int lastindex = progLangs.lastIndexOf("Spring Framework");

       System.out.println("lastindex "+lastindex);

        Iterator<String> iterator =progLangs.iterator();
        while(iterator.hasNext()){
            String prog= (String) iterator.next();
            System.out.println(prog);
        }
        progLangs.forEach(System.out::println);
        for(String e: progLangs){
            System.out.println(e);
        }
        progLangs.sort((o1, o2) -> o1.compareTo(o2));

        System.out.println("sorted LinkedList"+ progLangs);
    }
}
