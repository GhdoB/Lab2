package com.example.lab2.utils;

import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalc {
    public static int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) return 0;

        // Split on . ! ? (1 or more times)
        String[] sentences = text.trim().split("[.!?]+");

        int count = 0;
        for (String s : sentences) {
            if (!s.trim().isEmpty()) count++;
        }
        return count;
    }

    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) return 0;

        Pattern pattern = Pattern.compile("\\b[a-zA-Z]+\\b");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static int countPunctuation(String text) {
        if (text == null || text.isEmpty()) return 0;

        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == ',' || c == '!' || c == '?' || c == ':' || c == ';' || c == '"' || c == '(' || c == ')' || c == '[' || c == ']' || c == '-' || c == '/') {
                count++;
            }
        }
        return count;
    }

    public static int countNumbers(String text) {
        if (text == null || text.isEmpty()) return 0;

        int count = 0;
        boolean inNumber = false;

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!inNumber) {
                    count++;
                    inNumber = true;
                }
            } else {
                inNumber = false;
            }
        }
        return count;
    }

    public static int countAllChars (String text) {
        if (text == null) return 0;

        return text.length();
    }
}

