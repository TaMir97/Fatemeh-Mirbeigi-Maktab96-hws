package org.example.validations;

public class Validation {
    public static boolean inputLetterValidation(String letter) {
        String regex = "^[a-z]$";
        return letter.matches(regex);
    }
    public static boolean inputIntegerValidation(String integer) {
        String regex = "^[0-9]+$";
        return integer.matches(regex);
    }
}
