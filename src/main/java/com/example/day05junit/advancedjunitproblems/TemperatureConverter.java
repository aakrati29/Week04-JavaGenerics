package com.example.day05junit.advancedjunitproblems;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        System.out.println("0°C to Fahrenheit: " + celsiusToFahrenheit(0));  // Expected: 32.0
        System.out.println("100°F to Celsius: " + fahrenheitToCelsius(100)); // Expected: 37.77
    }
}

