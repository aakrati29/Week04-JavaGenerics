package com.example.day05regex.advancedproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateASocialSecurityNumber {


    public static boolean isValidSSN(String ssn) {
        // Regular expression for SSN format: XXX-XX-XXXX
        String regex = "^(?!000|666|9\\d{2})\\d{3}-\\d{2}-\\d{4}$";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        return matcher.matches();
    }
    public static void main(String[] args) {
        String[] testSSNs = {"123-45-6789", "123456789", "987-65-4321", "000-12-3456", "666-45-6789", "900-12-3456"};

        for (String ssn : testSSNs) {
            if (isValidSSN(ssn)) {
                System.out.println("\"" + ssn + "\" is valid");
            } else {
                System.out.println(" \"" + ssn + "\" is invalid");
            }
        }
    }

}
