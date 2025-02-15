package com.example.day05regex.basicregexproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColorCode {
    public static boolean isValidHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(color);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testColors = {"#FFA500", "#ff4500", "#123", "#123456", "#ZZZZZZ", "FFA500", "#abc123", "#ABC12G"};

        for (String color : testColors) {
            if (isValidHexColor(color)) {
                System.out.println("\"" + color + "\" → Valid");
            } else {
                System.out.println("\"" + color + "\" → Invalid");
            }
        }
    }
}

