package com.example.day05regex.replaceandmodifystrings;

public class ReplaceMultipleSpacesFromSingleSpace {

    private static void replace(String input, String regex) {
        String result = input.replaceAll(regex, " ");
        System.out.println("Result : " + result);
    }

    public static void main(String[] args) {
        String input = "This is  an   example   with     multiple   spaces.";
        String regex = "\\s+";

        replace(input, regex);
    }
}
