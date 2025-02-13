package com.example.day03javastreams.countwords;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week04-JavaGenerics\\src\\main\\java\\com\\example\\day03javastreams\\countwords\\file.txt"; // Replace with your file path
        countWords(filePath);
    }

    public static void countWords(String filePath) {
        Map<String, Integer> wordMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Normalize words (convert to lowercase, remove punctuation)
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Sort by value in descending order
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display top 5 most frequent words
        System.out.println("Top 5 most frequently occurring words:");
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            System.out.println(sortedList.get(i).getKey() + ": " + sortedList.get(i).getValue());
        }
    }
}
