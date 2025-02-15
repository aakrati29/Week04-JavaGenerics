package com.example.day05junit.basicjunitproblems;

class StringUtilsMethods {
    public String reverse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        StringUtilsMethods utils = new StringUtilsMethods();

        String str = "madam";
        System.out.println("Reverse of " + str + ": " + utils.reverse(str));
        System.out.println("Is " + str + " a palindrome? " + utils.isPalindrome(str));
        System.out.println("Uppercase of " + str + ": " + utils.toUpperCase(str));
    }
}

