package org.example.validations;

public class Validation {
    public static boolean inputValidation(String password) {
        String regex = "^[a-z]$";
        return password.matches(regex);
    }
}
