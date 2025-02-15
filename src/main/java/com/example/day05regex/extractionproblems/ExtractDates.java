package com.example.day05regex.extractionproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDates {

    private static void extractDates(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            System.out.println("Extracted date is : " + matcher.group());
        }
    }

    public static void main(String[] args) {
        String input = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        String regex = "\\b[0-9]{2}/[0-9]{2}/[0-9]{4}\\b";

        extractDates(input, regex);
    }
}
