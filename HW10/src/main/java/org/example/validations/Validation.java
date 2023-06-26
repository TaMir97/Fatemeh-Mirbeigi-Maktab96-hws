package org.example.validations;

public class Validation {
    public static boolean inputLetterValidation(String password) {
        String regex = "^[a-z]$";
        return password.matches(regex);
    }
    public static boolean inputIntegerValidation(String password) {
        String regex = "^[0-9]+$";
        return password.matches(regex);
    }
}
