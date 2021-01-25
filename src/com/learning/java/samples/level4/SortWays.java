package com.freshworks.java.samples.level4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;

import static java.util.Comparator.comparingInt;

// Sorting with function objects
public class SortWays
{
    public static void main(String[] args) {
        // List<String> words = Arrays.asList(args);

        List<String> words = Arrays.asList("hello", "world", "new", "syntax", "inheritance");

        // Anonymous class instance as a function object - obsolete!
        Collections.sort(words, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return Integer.compare(s1.length(), s2.length());
                }
            });
        System.out.println(words);
        Collections.shuffle(words);

        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words,
                         (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words);
        Collections.shuffle(words);

        // Comparator construction method (with method reference) in place of lambda
        Collections.sort(words, comparingInt(String::length));
        System.out.println(words);
        Collections.shuffle(words);

        // Default method List.sort in conjunction with comparator construction method
        words.sort(comparingInt(String::length));
        System.out.println(words);
    }
}
