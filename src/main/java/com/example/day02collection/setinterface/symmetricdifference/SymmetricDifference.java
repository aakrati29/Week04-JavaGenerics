package com.example.day02collection.setinterface.symmetricdifference;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    public static <T> HashSet<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        HashSet<T> result = new HashSet<>(set1);
        result.addAll(set2);

        HashSet<T> temp = new HashSet<>(set1);
        temp.retainAll(set2);

        result.removeAll(temp);
        return result;

    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4,3,5));

        HashSet<Integer> result = symmetricDifference(set1,set2);
        System.out.println("Symmetric Difference is : " + result);
    }
}
