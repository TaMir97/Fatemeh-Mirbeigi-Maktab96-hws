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
                validKeySet = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Set a valid key first.");
            }
        }
    }

    public String getKey() {
        return key;
    }

    public void setValues() {
        boolean validKeySet = false;
        while (!validKeySet) {
            try {
                this.values = Permutation.permutation(key);
                validKeySet = true;
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                System.out.println("Set a valid key first.");
                setKey();
            }
        }
    }

    public List<String> getValues() {
        return this.values;
    }

    public void setHashMap() {
        boolean validKeySet = false;
        while (!validKeySet) {
            try {
                this.hashMap = new HashMap<>();
                hashMap.put(this.key, this.values);
                validKeySet = true;
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                System.out.println("Set a valid key first.");
                setKey();
            }
        }

    }

    public Map<String, List<String>> getHashMap() {
        return this.hashMap;
    }

}
