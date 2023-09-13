package org.example.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "@#$%&";

    public static String generatePassword(int length) {

        SecureRandom random = new SecureRandom();
        List<Character> passwordChars = new ArrayList<>();

        passwordChars.add(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length())));
        passwordChars.add(SMALL_LETTERS.charAt(random.nextInt(SMALL_LETTERS.length())));
        passwordChars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        passwordChars.add(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < length; i++) {
            String allCharacters = CAPITAL_LETTERS + SMALL_LETTERS + DIGITS + SPECIAL_CHARACTERS;
            passwordChars.add(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        Collections.shuffle(passwordChars);

        StringBuilder password = new StringBuilder();
        for (Character character : passwordChars) {
            password.append(character);
        }

        return password.toString();
    }
}
