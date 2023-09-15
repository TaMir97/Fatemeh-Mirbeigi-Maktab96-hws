package org.example.util;

import junit.framework.TestCase;
import org.example.domain.CardInfo;


public class CardInfoTest extends TestCase {

    public void testValidCardInfo() {
        String[] validValues = {
                "5859831134567890",
                "6073998123456789",
                "5859831123456789",
                "6280852123456789"
        };

        for (String value : validValues) {
            try {
                new CardInfo().setValue(value);
            } catch (IllegalArgumentException e) {
                fail("IllegalArgumentException should not have been thrown for valid input: " + value);
            }
        }
    }

    public void testInvalidCardInfo() {
        String[] invalidValues = {
                "1234567890123456",
                "58596312345",
                "58596312345678901",
                "abcdefg1234567890"
        };

        for (String value : invalidValues) {
            try {
                new CardInfo().setValue(value);
                fail("Expected IllegalArgumentException was not thrown");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
