package com.example.demo18;

import java.util.Arrays;

public class Exercise19_4 {
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Double searchKey = 100.8;
        Double[] indexes = new Double[]{100.1, 100.3, 100.0, 100.8, 100.6};
        System.out.println(" returned index: " + linearSearch(indexes,searchKey) + ". When search key is " + searchKey + "Double values is: \n" + Arrays.toString(values));
    }
}
