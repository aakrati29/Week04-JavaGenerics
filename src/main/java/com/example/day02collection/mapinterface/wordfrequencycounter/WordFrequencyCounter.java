package com.example.day02collection.mapinterface.wordfrequencycounter;

import java.util.HashMap;

public class WordFrequencyCounter {
    static HashMap<String, Integer> countFrequency(String input) {
        HashMap<String, Integer> map = new HashMap<>();

        String[] words = input.toLowerCase().split("\\W+");

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        String input = "Hello world, hello Java!";

        HashMap<String,Integer> result = countFrequency(input);
        System.out.println(result);
    }
}
