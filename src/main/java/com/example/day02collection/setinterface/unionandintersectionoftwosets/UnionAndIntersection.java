package com.example.day02collection.setinterface.unionandintersectionoftwosets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {
    private static <T> HashSet<T> union(Set<T> set1, Set<T> set2){
        HashSet<T> result = new HashSet<>(set1);
        result.addAll(set2);

        return result;
    }

    private static <T> HashSet<T> intersection(Set<T> set1, Set<T> set2){
        HashSet<T> result = new HashSet<>(set1);
        result.retainAll(set2);

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4,3,5));

        System.out.println(union(set1,set2));
        System.out.println(intersection(set1,set2));
    }
}
