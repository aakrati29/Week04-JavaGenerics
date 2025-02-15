package com.example.day05junit.advancedjunitproblems;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;

public class DateFormatter {

    public static String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            return "Invalid Date Format";
        }
    }

    public static void main(String[] args) {
        System.out.println(formatDate("2024-02-16"));
        System.out.println(formatDate("2024/02/16"));
    }
}

