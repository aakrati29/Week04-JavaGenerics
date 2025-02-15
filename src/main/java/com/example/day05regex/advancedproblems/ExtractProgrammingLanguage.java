package com.example.day05regex.advancedproblems;

import java.util.ArrayList;
import java.util.List;

public class ExtractProgrammingLanguage {

        public static void main(String[] args) {
            String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
            String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "PHP", "Rust", "Kotlin"};

            List<String> foundLanguages = new ArrayList<>();

            for (String lang : languages) {
                if (text.matches(".*\\b" + lang + "\\b.*")) {
                    foundLanguages.add(lang);
                }
            }

            System.out.println(String.join(", ", foundLanguages));
        }
    }
