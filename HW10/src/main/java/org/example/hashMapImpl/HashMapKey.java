package org.example.hashMapImpl;

import java.util.*;

public class HashMapKey {
    private final Scanner input;
    private Map<String, List<String>> hashMap;
    private String key;
    private List<String> values;

    public HashMapKey() {
        this.input = new Scanner(System.in);
    }

    public void setKey() {
        boolean validKeySet = false;
        while (!validKeySet) {
            try {
                System.out.print("Enter the Key: ");
                this.key = input.nextLine();
                if (this.key.length() <= 1)
                    throw new IndexOutOfBoundsException();
                validKeySet = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Set a valid key first.");
            }
        }
    }


    public void setValues() {
        try {
            if (this.key == null)
                throw new NullPointerException();
            this.values = Permutation.permutation(key);
        } catch (NullPointerException e) {
            System.out.println("You have no keys to have its value(s).");
        }
    }


    public void setHashMap() {
        try {
            if (this.key == null)
                throw new NullPointerException();
            this.hashMap = new HashMap<>();
            hashMap.put(this.key, this.values);
        } catch (NullPointerException e) {
            System.out.println("You have no keys to have its HashMap.");
        }
    }

    public Map<String, List<String>> getHashMap() {
        return this.hashMap;
    }

}
