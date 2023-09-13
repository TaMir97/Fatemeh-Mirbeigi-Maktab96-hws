package org.example.util;

import junit.framework.TestCase;

public class PasswordGeneratorTest extends TestCase {

    public void testGeneratePassword() {
        assertEquals(8,PasswordGenerator.generatePassword(8).length());
    }
}