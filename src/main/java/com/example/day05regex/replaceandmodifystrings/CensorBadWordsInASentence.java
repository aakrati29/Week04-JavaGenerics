package com.example.day05regex.replaceandmodifystrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CensorBadWordsInASentence {
    public static String searchBadWords(String input, List<String> badWords){
        for (String word : badWords) {
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            input = matcher.replaceAll("*****");
        }
        return input;

    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWord = new ArrayList<>(Arrays.asList("damn", "stupid"));

        System.out.println("Result : " + searchBadWords(input, badWord));
    }
}
