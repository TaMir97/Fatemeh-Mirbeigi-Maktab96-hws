package org.example.hashMapScratch;

import java.util.*;

public class MyHashMap<K, V> {
    private final List<Inputs<K, V>> inputs;

    public MyHashMap() {
        inputs = new ArrayList<>();
    }

    public void put(K key, V value) {
        Inputs<K, V> input = getInput(key);
        if (input != null) {
            input.getValues().add(value);
        } else {
            List<V> values = new ArrayList<>();
            values.add(value);
            inputs.add(new Inputs<>(key, values));
        }
    }

    public List<V> get(K key) {
        Inputs<K, V> input = getInput(key);
        return input != null ? input.getValues() : new ArrayList<>();
    }

    public void remove(K key) {
        Inputs<K, V> input = getInput(key);
        if (input != null) {
            inputs.remove(input);
        }
    }

    public void printValues() {
        for (Inputs<K, V> input : inputs) {
            K key = input.getKey();
            List<V> values = input.getValues();
            System.out.println("{" + key + "=" + values + "}");
        }
    }

    public boolean isEmpty() {
        return inputs.isEmpty();
    }

    public void replace(K key, List<V> newValues) {
        Inputs<K, V> input = getInput(key);
        if (input != null) {
            input.setValues(newValues);
        }
    }

    public boolean isExist(K key) {
        return getInput(key) != null;
    }

    private Inputs<K, V> getInput(K key) {
        for (Inputs<K, V> input : inputs) {
            if (input.getKey().equals(key)) {
                return input;
            }
        }
        return null;
    }

}
