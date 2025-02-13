package com.example.day03javastreams.readlargefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {
    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\Week04-JavaGenerics\\src\\main\\java\\com\\example\\day03javastreams\\readlargefile\\file.txt"; // Replace with the actual file path
        readAndFilterFile(filePath);
    }

    public static void readAndFilterFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
