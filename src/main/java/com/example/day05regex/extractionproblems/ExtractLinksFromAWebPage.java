package com.example.day05regex.extractionproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinksFromAWebPage {

    private static void extractLinks(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            System.out.println("Extracted links is : " + matcher.group());
        }
    }

    public static void main(String[] args) {
        String input = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "\\bhttps?://(www.-)?[a-zA-Z\\d@#$%.]+\\b";

        extractLinks(input, regex);
    }
}
