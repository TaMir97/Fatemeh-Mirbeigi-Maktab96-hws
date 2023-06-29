package org.example;


import org.example.arrayListImpl.ProperList;
import org.example.hashMapImpl.HashMapKey;
import org.example.hashMapImpl.PermuteChecker;
import org.example.hashMapScratch.MyHashMap;
import org.example.treeSetImpl.TreeSetImpl;
import org.example.validations.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String runItem;
        boolean breakLoop = false;

        while (!breakLoop) {
            Printer.printMenu(Constants.RUN_ITEMS);
            runItem = input.nextLine();
            if (!Validation.inputIntegerValidation(runItem))
                Printer.printMsg("Wrong choice.");
            else {
                switch (Integer.parseInt(runItem)) {
                    case 1 -> {
                        HashMapKey hashMapKey = new HashMapKey();
                        hashMapKey.setKey();
                        hashMapKey.setValues();
                        hashMapKey.setHashMap();
                        System.out.println(hashMapKey.getHashMap());
                    }
                    case 2 -> {
                        PermuteChecker permuteChecker = new PermuteChecker();
                        permuteChecker.isPermutation();
                    }
                    case 3 -> {
                        TreeSetImpl treeSetImpl = new TreeSetImpl();

                        treeSetImpl.fillTwoSets();

                        System.out.println(treeSetImpl.getFirstList());
                        System.out.println(treeSetImpl.getSecondList());

                        System.out.println(treeSetImpl.getUnionSet());
                        System.out.println(treeSetImpl.getIntersectionSet());
                    }
                    case 4 -> {
                        ProperList properList = new ProperList();
                        System.out.println(properList.fillList());
                        System.out.println(properList.getProperList());
                    }
                    case 5 -> {
                        MyHashMap<String, Integer> hashMap = new MyHashMap<>();

                        hashMap.put("numbers", 1);
                        hashMap.put("numbers", 2);
                        hashMap.put("numbers", 3);

                        hashMap.put("letters", 4);
                        hashMap.put("letters", 5);

                        hashMap.printValues();

                        System.out.println("Is map empty? " + hashMap.isEmpty());

                        List<Integer> numbers = hashMap.get("numbers");
                        System.out.println("Values for 'numbers': " + numbers);

                        System.out.println("Does 'letters' exist? " + hashMap.isExist("letters"));

                        hashMap.remove("numbers");

                        List<Integer> newValues = new ArrayList<>();
                        newValues.add(6);
                        newValues.add(7);
                        hashMap.replace("letters", newValues);

                        hashMap.printValues();
                    }
                    case 6 -> {
                        breakLoop = true;
                    }
                    default -> {
                        Printer.printMsg("The choice doesn't exist. ");
                    }
                }

            }
        }
    }
}
