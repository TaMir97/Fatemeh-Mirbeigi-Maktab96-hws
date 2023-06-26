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

    public Map<String, List<String>> getMappedValues() {
        Map<String, List<String>> finalMap = new HashMap<>();
        boolean validKeySet = false;
        while (!validKeySet) {
            try {
                String key = setKey();
                finalMap.put(key, Permutation.permutation(key));
                validKeySet = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Set a valid key first.");
            }
        }

        return finalMap;
    }


    public String setKey() {
        System.out.print("Enter the Key: ");
        return input.nextLine();
    }
}
