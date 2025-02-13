package com.example.day02collection.listinterface.findfrequency;

import java.util.HashMap;

public class FindFrequency {
    private static HashMap<String,Integer> countFrequency(String[] input) {
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < input.length; i++){
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String input[] = {"apple", "banana", "apple", "orange"};
        HashMap<String,Integer> result = countFrequency(input);
        System.out.println(result);
    }
}
