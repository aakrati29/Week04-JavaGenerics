package com.example.day04exceptions.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoClosingResources {

    public static void checkIOException(){
        try(BufferedReader br = new BufferedReader(new FileReader("info"))){

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
    public static void main(String[] args) {
        checkIOException();
    }
}
