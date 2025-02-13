package com.example.day02collection.setinterface.convertasettoasortedlist;

import java.util.*;

public class ConvertSeToSortedList {
    public static List<Integer> convertSetToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(5, 3, 9, 1));

        List<Integer> result = convertSetToSortedList(set);
        System.out.println("Convert Set to Sorted List : " + result);
    }
}
