package com.example.day05junit.basicjunitproblems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileProcessor {

    public void writeToFile(String filename, String content) throws IOException {
        Path filePath = Path.of(filename);
        Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public String readFromFile(String filename) throws IOException {
        Path filePath = Path.of(filename);
        return Files.readString(filePath);
    }

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        System.out.print("Enter content to write: ");
        String content = scanner.nextLine();

        try {
            fileProcessor.writeToFile(filename, content);
            System.out.println("Content written successfully!");

            String readContent = fileProcessor.readFromFile(filename);
            System.out.println("File content: " + readContent);
        }
        catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}
