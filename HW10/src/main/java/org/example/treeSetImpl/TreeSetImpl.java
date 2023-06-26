package org.example.treeSetImpl;

import org.example.exception.InvalidInputException;
import org.example.validations.Validation;

import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetImpl {
    private final Scanner input;
    private TreeSet<String> firstList;
    private TreeSet<String> secondList;
    private TreeSet<String> unionSet;
    private TreeSet<String> intersectionSet;
    private static final int INPUT_ELEMENTS = 10;

    public TreeSetImpl() {
        this.input = new Scanner(System.in);
        this.firstList = new TreeSet<>();
        this.secondList = new TreeSet<>();
        this.unionSet = new TreeSet<>();
        this.intersectionSet = new TreeSet<>();
    }

    public void fillTwoSets() {
        for (int i = 1; i <= INPUT_ELEMENTS; i++) {
            System.out.println("Filling First Set ...");
            try {
                fillSets(this.firstList);
            } catch (InvalidInputException e) {
                i--;
                System.out.println("Wrong input format.");
            }
        }
        System.out.println("===");
        for (int i = 1; i <= INPUT_ELEMENTS; i++) {
            System.out.println("Filling Second Set ...");
            try {
                fillSets(this.secondList);
            } catch (InvalidInputException e) {
                i--;
                System.out.println("Wrong input format.");
            }
        }
    }

    private void fillSets(TreeSet<String> set) {
        System.out.println("Enter a letter: ");
        String letter = input.nextLine();
        if (Validation.inputValidation(letter)) {
            set.add(letter);
        } else {
            throw new InvalidInputException();
        }
    }

    public TreeSet<String> getFirstList() {
        return firstList;
    }

    public TreeSet<String> getSecondList() {
        return secondList;
    }

    public TreeSet<String> getUnionSet() {
        this.unionSet.addAll(firstList);
        this.unionSet.addAll(secondList);
        return  this.unionSet;
    }

    public TreeSet<String> getIntersectionSet() {
        this.intersectionSet.addAll(firstList);
        this.intersectionSet.retainAll(secondList);
        return intersectionSet;
    }
}
