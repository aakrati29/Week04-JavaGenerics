package com.example.day05regex.extractionproblems;

import java.util.regex.Matcher;
import  java.util.regex.Pattern;

public class ExtractAllCapitalizedWords {

    public static void extractCapitalWords(String input, String regex){
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            System.out.println("Extracted capitalized word from a sentence : " + matcher.group());
        }
    }
    public static void main(String[] args) {
        String input = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String regex = "\\b[A-Z][a-zA-Z]+\\b";

        extractCapitalWords(input,regex);
    }
}
