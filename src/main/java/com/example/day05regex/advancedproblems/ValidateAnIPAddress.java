package com.example.day05regex.advancedproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAnIPAddress {
    private static void validateIPAddress(String[] input, String regex) {
        Pattern pattern = Pattern.compile(regex);

            for(String string : input) {
                Matcher matcher = pattern.matcher(string);
                System.out.printf("The IP address \"%s\"  is valid : %s%n",string, matcher.matches());            }
    }
    public static void main(String[] args) {
        String[] input = {"122.84.255.165", "14,255,457", "124.85.14.255"};
        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}" +
                "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])$";;

        validateIPAddress(input, regex);

    }
}
