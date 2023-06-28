package org.example.hashMapImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    protected static List<String> permutation(String word) {
        List<String> result = new ArrayList<>();
        int count = 1;
        int wordLength = word.length();

        while (count < factorial(wordLength) + 1) {
            char[] eachChar = word.toCharArray();

            for (int i = 0; i < wordLength; i++) {
                String newWord = Character.toString(eachChar[i]);
                for (int k = 0; k < wordLength; k++) {
                    if (i != k) {
                        newWord += eachChar[k];
                    } else if (i == wordLength - 1) {
                        result.add(newWord);
                        count++;
                        newWord = swapLetters(newWord, k, k - 1);
                        result.add(newWord);
                    }
                }
                if (i != wordLength - 1) {
                    result.add(newWord);
                    count++;
                }
                word = newWord;
            }
        }
        Set<String> uniqueSet = new HashSet<>(result);
        return new ArrayList<>(uniqueSet);
    }

    private static String swapLetters(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    private static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
