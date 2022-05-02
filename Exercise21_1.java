package com.example.demo18;
import java.util.*;

public class Exercise21_1 {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>(Arrays.asList(
                "George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> set2 = new LinkedHashSet<>(Arrays.asList(
                "George", "Katie", "Kevin", "Michelle", "Ryan"));
        Set<String> union = new LinkedHashSet<>(set1);
        union.addAll(set2);
        System.out.println("union:" + union);
        Set<String> difference = new LinkedHashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("intersection: " + difference);
        Set<String> intersection = new LinkedHashSet<>();
        for (String e: set2) {
            if (set1.contains(e))
                intersection.add(e);
        }
        System.out.println("Intersection" + intersection);
    }
}

