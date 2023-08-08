package com.example;

public class RelationalCalc {
    private int numerator;
    private int denominator;

    public RelationalCalc() {
        this.numerator = 0;
        this.denominator = 1;
    }


    public void setRatio(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }


    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public StringBuilder fractionSimplifier() {
        int gcd = calculateGCD(this.numerator, this.denominator);

        int wholePart;
        int numeratorPart;
        int denominatorPart;
        StringBuilder fractionBuilder = new StringBuilder();

        if (this.denominator / gcd == 1) {
            wholePart = this.numerator/gcd;
            fractionBuilder.append(wholePart);
            return fractionBuilder;

        } else if (this.numerator / gcd < this.denominator / gcd) {
            numeratorPart = this.numerator / gcd;
            denominatorPart = this.denominator / gcd;
            fractionBuilder.append(numeratorPart);
            fractionBuilder.append("/");
            fractionBuilder.append(denominatorPart);
            return fractionBuilder;
        } else {
            wholePart = (this.numerator / gcd) / (this.denominator / gcd);
            numeratorPart = (this.numerator / gcd) % (this.denominator / gcd);
            denominatorPart = this.denominator / gcd;
            fractionBuilder.append(wholePart);
            fractionBuilder.append("+");
            fractionBuilder.append(numeratorPart);
            fractionBuilder.append("/");
            fractionBuilder.append(denominatorPart);
            return fractionBuilder;
        }

    }

    public RelationalCalc add(RelationalCalc newNumber) {
        RelationalCalc relationalCalc = new RelationalCalc();
        int newNumerator = (this.numerator * newNumber.denominator) + (newNumber.numerator * this.denominator);
        int newDenominator = this.denominator * newNumber.denominator;
        relationalCalc.setRatio(newNumerator, newDenominator);

        return relationalCalc;
    }

    public RelationalCalc sub(RelationalCalc newNumber) {
        RelationalCalc relationalCalc = new RelationalCalc();
        int newNumerator = (this.numerator * newNumber.denominator) - (newNumber.numerator * this.denominator);
        int newDenominator = this.denominator * newNumber.denominator;
        relationalCalc.setRatio(newNumerator, newDenominator);

        return relationalCalc;
    }

    public RelationalCalc mul(RelationalCalc num) {
        RelationalCalc relationalCalc = new RelationalCalc();
        int newNumerator = this.numerator * num.numerator;
        int newDenominator = this.denominator * num.denominator;
        relationalCalc.setRatio(newNumerator, newDenominator);

        return relationalCalc;
    }

    public RelationalCalc div(RelationalCalc num) {
        RelationalCalc relationalCalc = new RelationalCalc();
        int newNumerator = this.numerator * num.denominator;
        int newDenominator = this.denominator * num.numerator;
        relationalCalc.setRatio(newNumerator, newDenominator);

        return relationalCalc;
    }

    public double toFloatingPoint() {
        return (double) this.numerator / (double) this.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
