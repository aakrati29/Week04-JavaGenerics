package com.example.day05regex.advancedproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateACreditCardNumber {

    private static void validateCardNumber(String[] input, String regex) {
        Pattern pattern = Pattern.compile(regex);

        for(String string : input) {
            Matcher matcher = pattern.matcher(string);
            System.out.printf("The IP address \"%s\"  is valid : %s%n",string, matcher.matches());            }
    }

    public static void main(String[] args) {
        String[] input = {"5111111121411112","4222222222224572", "60111111117", "378282246310005", "5051051051022220"};
        String regex = "^(4[0-9]{15})|(5[0-9]{15})";

        validateCardNumber(input, regex);
    }
}
