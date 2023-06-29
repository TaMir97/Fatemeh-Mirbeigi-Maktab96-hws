package org.example.arrayListImpl;

import org.example.exception.InvalidInputException;
import org.example.validations.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProperList {
    private static Scanner input;
    private ArrayList<Integer> properList;
    private ArrayList<Integer> improperList;
    private int initialSize;

    public ProperList() {
        input = new Scanner(System.in);
        properList = new ArrayList<>();
        improperList = new ArrayList<>();
    }

    public ArrayList<Integer> getProperList() {
        if (initialSize % 2 != 0) {
            improperList.remove(initialSize - 1);
        }
        for (int i = 0; i < initialSize; i = i + 2) {
            if (improperList.get(i) >= improperList.get(i + 1)) {
                properList.add(improperList.get(i));
                properList.add(improperList.get(i + 1));
            }
        }
        return properList;
    }


    public List<Integer> fillList() {
        String key;
        String number;
        boolean validKeySet = false;
        while (!validKeySet) {
            System.out.println("Want to enter an integer? (y/n)");
            key = input.nextLine();
            switch (key.toLowerCase()) {
                case "y": {
                    try {
                        System.out.println("enter: ");
                        number = input.nextLine();
                        if (!Validation.inputIntegerValidation(number)) {
                            throw new InvalidInputException();
                        }
                        improperList.add(Integer.valueOf(number));
                    } catch (InvalidInputException e) {
                        System.out.println("Not a valid input.");
                    }
                    break;
                }
                case "n": {
                    validKeySet = true;
                    break;
                }
                default:
                    System.out.println("invalid input.");
                    break;
            }
        }
        this.initialSize = improperList.size();
        return improperList;
    }
}
