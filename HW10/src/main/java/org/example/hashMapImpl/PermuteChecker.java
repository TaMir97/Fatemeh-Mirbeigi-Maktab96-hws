package org.example.hashMapImpl;

import org.example.exception.InvalidInputException;

import java.util.*;

public class PermuteChecker {
    private final Scanner input;
    private String firstInput;
    private String secondInput;


    public PermuteChecker() {
        input = new Scanner(System.in);
    }

    private void getInputs() {
        System.out.println("first input");
        this.firstInput = input.nextLine();
        System.out.println("second input");
        this.secondInput = input.nextLine();
        if (firstInput.length() <= 1 | secondInput.length() <= 1) {
            throw new InvalidInputException();
        }
    }

    public void isPermutation() {
        try {
            getInputs();
            List<String> allPermutations = Permutation.permutation(firstInput);
            Map<String, List<String>> map = new HashMap<>();
            map.put(firstInput, allPermutations);
            if (map.get(firstInput).contains(secondInput)) {
                System.out.println("passed");
                return;
            }
            System.out.println("failed");
        } catch (InvalidInputException e) {
            System.out.println("The inputs ate not valid");
        }
    }
}
