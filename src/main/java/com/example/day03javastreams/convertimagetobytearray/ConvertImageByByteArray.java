package com.example.day03javastreams.convertimagetobytearray;

import java.io.*;
import java.nio.file.*;

public class ConvertImageByByteArray {
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        return Files.readAllBytes(Paths.get(imagePath));
    }

    public static void byteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(bais.readAllBytes());
        }
    }

    public static void main(String[] args) {
        String inputImage = "D:\\Capgemini\\Week04-JavaGenerics\\src\\main\\java//com//example//day03javastreams//convertimagetobytearray//image.jpg";
        String outputImage = "D:\\Capgemini\\Week04-JavaGenerics\\src\\main\\java\\com\\example\\day03javastreams\\convertimagetobytearray\\output.jpg";

        try {
            byte[] imageBytes = imageToByteArray(inputImage);
            System.out.println("Image converted to byte array successfully!");

            byteArrayToImage(imageBytes, outputImage);
            System.out.println("Byte array written back to image successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

