package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelationalCalcTest {

    @Test
    void constructorTest(){
        RelationalCalc relationalCalc = new RelationalCalc();
        assertEquals(0,relationalCalc.getNumerator());
        assertEquals(1,relationalCalc.getDenominator());
    }

    @Test
    void setRatioTest() {
        RelationalCalc relationalCalc = new RelationalCalc();
        try {
            relationalCalc.setRatio(5,0);
            fail("Expected IllegalArgumentException but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Denominator cannot be zero.", e.getMessage());
        }
    }


    private RelationalCalc calc;

    @BeforeEach
    public void setUp() {
        calc = new RelationalCalc();
    }

    @Test
    public void testFractionSimplifierWholePart() {
        calc.setRatio(8, 4);

        StringBuilder result = calc.fractionSimplifier();

        assertEquals("2", result.toString());
    }

    @Test
    public void testFractionSimplifierProperFraction() {
        calc.setRatio(3, 4);

        StringBuilder result = calc.fractionSimplifier();

        assertEquals("3/4", result.toString());
    }

    @Test
    public void testFractionSimplifierMixedFraction() {
        calc.setRatio(10, 4);

        StringBuilder result = calc.fractionSimplifier();

        assertEquals("2+1/2", result.toString());
    }

    private RelationalCalc calc1;
    private RelationalCalc calc2;

    @BeforeEach
    public void setUp2() {
        calc1 = new RelationalCalc();
        calc2 = new RelationalCalc();
    }

    @Test
    public void testAdd() {
        calc1.setRatio(2, 4);
        calc2.setRatio(3, 4);

        RelationalCalc result = calc1.add(calc2);
        StringBuilder finalResult = result.fractionSimplifier();

        assertEquals("1+1/4", finalResult.toString());

    }

    @Test
    public void testSub() {
        calc1.setRatio(3, 4);
        calc2.setRatio(1, 4);

        RelationalCalc result = calc1.sub(calc2);
        StringBuilder finalResult = result.fractionSimplifier();

        assertEquals("1/2", finalResult.toString());
    }

    @Test
    public void testMul() {
        calc1.setRatio(2, 3);
        calc2.setRatio(3, 4);

        RelationalCalc result = calc1.mul(calc2);
        StringBuilder finalResult = result.fractionSimplifier();

        assertEquals("1/2", finalResult.toString());
    }

    @Test
    public void testDiv() {
        calc1.setRatio(1, 2);
        calc2.setRatio(3, 4);

        RelationalCalc result = calc1.div(calc2);
        StringBuilder finalResult = result.fractionSimplifier();

        assertEquals("2/3", finalResult.toString());
    }

    @Test
    public void testToFloatingPoint() {
        calc1.setRatio(1, 2);

        double result = calc1.toFloatingPoint();

        assertEquals(0.5, result, 0.001); // Add a tolerance for floating-point comparisons
    }
}