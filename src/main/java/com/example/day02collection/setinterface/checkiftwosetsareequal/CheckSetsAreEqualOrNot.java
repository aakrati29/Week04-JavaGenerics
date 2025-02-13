package com.example.day02collection.setinterface.checkiftwosetsareequal;

import java.util.HashSet;

public class CheckSetsAreEqualOrNot {
    private static <T> boolean checkSetsAreEqualOrNot(HashSet<T> set1, HashSet<T> set2) {
        if(set1.size() != set2.size()){
            return false;
        }
        for (int i = 0; i < set1.size(); i++){
            if(set1.equals(set2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(1);

        boolean result = checkSetsAreEqualOrNot(set1, set2);
        System.out.println(result);
    }
}
