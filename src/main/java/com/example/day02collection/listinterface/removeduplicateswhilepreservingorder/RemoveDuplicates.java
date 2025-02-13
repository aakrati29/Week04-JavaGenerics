package com.example.day02collection.listinterface.removeduplicateswhilepreservingorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicate(List<T> list) {
        List<T> result = new ArrayList<>();
        HashSet<T> set = new HashSet<>();
        for(T i : list){
            if(!set.contains(i)){
                set.add(i);
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        List<Integer> result = removeDuplicate(list);
        System.out.println(result);
    }
}
