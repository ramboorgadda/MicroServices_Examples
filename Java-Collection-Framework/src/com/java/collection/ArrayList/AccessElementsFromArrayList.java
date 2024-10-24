package com.java.collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class AccessElementsFromArrayList {

    public static void main(String[] args) {
        List<String> topProgrammingLang = new ArrayList<>();
        System.out.println(topProgrammingLang.isEmpty());
        topProgrammingLang.add("C");
        topProgrammingLang.add("C++");
        topProgrammingLang.add("Java");
        topProgrammingLang.add("Python");
        topProgrammingLang.add(".net");
        System.out.println("size "+topProgrammingLang.size());
        String bestProgrammingLang = topProgrammingLang.get(2);

        System.out.println("Best lang "+bestProgrammingLang);

        String secondBestProgrammingLang = topProgrammingLang.get(3);

        System.out.println("sencondBest lang "+secondBestProgrammingLang);

        topProgrammingLang.set(4,"C#");
        System.out.println(topProgrammingLang);
    }
}
