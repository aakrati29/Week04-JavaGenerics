package com.example.day03javastreams.readuserinputfromconsole;

import java.io.*;

public class UserInputToFile {
    public static void saveUserInput(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        String name = reader.readLine();

        System.out.print("Enter your age: ");
        int age = Integer.parseInt(reader.readLine());

        System.out.print("Enter your favorite programming language: ");
        String language = reader.readLine();

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
        }

        System.out.println("User information saved to " + filePath);
    }

    public static void main(String[] args) {
        try {
            saveUserInput("D://Capgemini//Week04-JavaGenerics//src//main//java//com//example//day03javastreams//readuserinputfromconsole//Input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

