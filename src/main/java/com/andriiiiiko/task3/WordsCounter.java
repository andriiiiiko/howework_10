package com.andriiiiiko.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordsCounter {
    private static final String RELATIVE_PATH = "src/main/java/com/andriiiiiko/task3/words.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(RELATIVE_PATH))) {
            String line = bufferedReader.readLine();
            Map<String, Integer> counter = new HashMap<>();

            while (line != null) {
                countWords(line, counter);
                line = bufferedReader.readLine();
            }

            for (Map.Entry<String, Integer> entry : counter.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static Map<String, Integer> countWords(String line, Map<String, Integer> counter) {
        String[] words = line.split(" ");
        for (String word : words) {
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
        return counter;
    }
}