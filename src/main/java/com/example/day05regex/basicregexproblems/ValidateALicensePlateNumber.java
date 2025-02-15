package com.example.day05regex.basicregexproblems;

import java.util.regex.Matcher;
import  java.util.regex.Pattern;

public class ValidateALicensePlateNumber {
    public static void main(String[] args) {
        String[] input = {"AB1234", "A12345"};
        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        for(String string : input){
            Matcher matcher = pattern.matcher(string);
            System.out.printf("The license plate number \"%s\"  is valid : %s%n",string, matcher.matches());
        }
    }
}
