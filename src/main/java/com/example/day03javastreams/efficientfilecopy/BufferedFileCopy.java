package com.example.day03javastreams.efficientfilecopy;

import java.io.*;

public class BufferedFileCopy {
    public static void copyFileBuffered(String sourcePath, String destinationPath) throws IOException {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destinationPath))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        String sourcePath = "D://Capgemini//Week04-JavaGenerics//src//main//java//com//example//day03javastreams//efficientfilecopy//file.txt";
        String destinationPath = "D://Capgemini//Week04-JavaGenerics//src//main//java//com//example//day03javastreams//efficientfilecopy//output.txt";
        try {
            copyFileBuffered(sourcePath,destinationPath);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}