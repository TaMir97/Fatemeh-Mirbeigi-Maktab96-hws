package org.example.treeSetImpl;

import org.example.exception.InvalidInputException;
import org.example.validations.Validation;

import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetImpl {
    private final Scanner input;
    private final TreeSet<String> FIRST_LIST;
    private final TreeSet<String> SECOND_LIST;
    private final TreeSet<String> UNION_SET;
    private final TreeSet<String> INTERSECTION_SET;
    private static final int INPUT_ELEMENTS = 10;

    public TreeSetImpl() {
        this.input = new Scanner(System.in);
        this.FIRST_LIST = new TreeSet<>();
        this.SECOND_LIST = new TreeSet<>();
        this.UNION_SET = new TreeSet<>();
        this.INTERSECTION_SET = new TreeSet<>();
    }

    public void fillTwoSets() {
        for (int i = 1; i <= INPUT_ELEMENTS; i++) {
            System.out.println("Filling First Set ...");
            try {
                fillSets(this.FIRST_LIST);
            } catch (InvalidInputException e) {
                i--;
                System.out.println("Wrong input format.");
            }
        }
        System.out.println("===");
        for (int i = 1; i <= INPUT_ELEMENTS; i++) {
            System.out.println("Filling Second Set ...");
            try {
                fillSets(this.SECOND_LIST);
            } catch (InvalidInputException e) {
                i--;
                System.out.println("Wrong input format.");
            }
        }
    }

    private void fillSets(TreeSet<String> set) {
        System.out.println("Enter a letter: ");
        String letter = input.nextLine();
        if (Validation.inputLetterValidation(letter)) {
            set.add(letter);
            return;
        }
        throw new InvalidInputException();
    }

    public TreeSet<String> getFirstList() {
        return FIRST_LIST;
    }

    public TreeSet<String> getSecondList() {
        return SECOND_LIST;
    }

    public TreeSet<String> getUnionSet() {
        this.UNION_SET.addAll(FIRST_LIST);
        this.UNION_SET.addAll(SECOND_LIST);
        return this.UNION_SET;
    }

    public TreeSet<String> getIntersectionSet() {
        this.INTERSECTION_SET.addAll(FIRST_LIST);
        this.INTERSECTION_SET.retainAll(SECOND_LIST);
        return INTERSECTION_SET;
    }
}
