package org.example.hashMapImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HashMapKey {
    private final Scanner input;

    public HashMapKey() {
        this.input = new Scanner(System.in);
    }

    public Map<String, List<String>> getFinalMap() {
        Map<String, List<String>> finalMap = new HashMap<>();
        try {
            String key = setKey();
            finalMap.put(key, Permutation.permutation(key));
        } catch (NullPointerException e) {
            System.out.println("set the key first.");
        }
        return finalMap;
    }

    public String setKey() {
        while (true) {
            System.out.print("Enter the Key: ");
            try {
                return input.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ender a key with more than one letter:");
            }
        }
    }
}
