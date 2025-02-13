package com.example.day03javastream.countwords;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {

    @Test
    void testWordCount() throws IOException {
        // Create a temporary test file
        File tempFile = File.createTempFile("test_file", ".txt");
        tempFile.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("error error warning test sample\n");
            writer.write("sample test error warning warning\n");
            writer.write("sample sample sample test test\n");
        }

        // Run word count method
        Map<String, Integer> result = getWordCount(tempFile.getAbsolutePath());

        // Expected word frequencies
        Map<String, Integer> expected = new HashMap<>();
        expected.put("sample", 5);
        expected.put("test", 4);
        expected.put("error", 3);
        expected.put("warning", 3);

        // Verify results
        assertEquals(expected.get("sample"), result.get("sample"));
        assertEquals(expected.get("test"), result.get("test"));
        assertEquals(expected.get("error"), result.get("error"));
        assertEquals(expected.get("warning"), result.get("warning"));
    }

    private Map<String, Integer> getWordCount(String filePath) throws IOException {
        Map<String, Integer> wordMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        return wordMap;
    }
}

