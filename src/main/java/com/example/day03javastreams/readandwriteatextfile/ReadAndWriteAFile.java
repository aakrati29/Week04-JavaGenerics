package com.example.day03javastreams.readandwriteatextfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteAFile {
    public static void readFile(){
        try(FileReader read = new FileReader("D://Capgemini//Week04-JavaGenerics//src//main//java//com//example//day03javastreams//readandwriteatextfile//file.txt");
            BufferedReader br = new BufferedReader(read)){

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFile(){
        try(FileReader read = new FileReader("D://Capgemini//Week04-JavaGenerics//src//main//java//com//example//day03javastreams//readandwriteatextfile//file.txt");
            FileWriter write = new FileWriter("D://Capgemini//Week04-JavaGenerics//src//main//java//com//example//day03javastreams//readandwriteatextfile//output.txt");
            BufferedReader br = new BufferedReader(read)){

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                write.write(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        readFile();
        writeFile();
    }
}
