package com.example.day05regex.extractionproblems;

import java.util.regex.Matcher;
import  java.util.regex.Pattern;

public class ExtractAllEmailAddresses {
    public static void main(String[] args) {
        String str = "Contact us at support@example.com and info@company.org";
        String regex = "[a-zA-Z0-9-.+]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        while(matcher.find()){
            System.out.println("Extracted email id is : " + matcher.group());
        }
    }
}
