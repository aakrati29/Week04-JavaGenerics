package com.example.day05regex.validateausername;

import java.util.regex.Matcher;
import  java.util.regex.Pattern;
public class ValidateAUsername {
    public static void main(String[] args) {
        String[] unit = {"user_123","123user", "us"};
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";

        Pattern patter = Pattern.compile(regex);

        for(String str : unit){
            Matcher matcher = patter.matcher(str);
            System.out.println("The username "+str+" is valid : "+ matcher.matches());
        }
    }
}
