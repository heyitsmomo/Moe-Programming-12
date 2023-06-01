package com.moe.module24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Word {
    /**
     * MAIN METHOD
     * @param args not used
     */
    public static void main(String[] args) {
        Set<String> uniqueWords = new HashSet<>();

        try {
            File file = new File("/Users/moe/IdeaProjects/Module 2 Assignment/src/com/moe/module24/illiad.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!cleanedWord.isEmpty()) {
                        uniqueWords.add(cleanedWord);
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        int uniqueWordCount = uniqueWords.size();
        System.out.println("Number of unique words: " + uniqueWordCount);
    }
}
