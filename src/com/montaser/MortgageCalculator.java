package com.montaser;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    public double calculateRemainin(int month) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double remainingAmount = principal *
                (Math.pow((1 + monthlyInterest), numberOfPayments) - (Math.pow((1 + monthlyInterest), month))) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);

        return remainingAmount;
    }

    public int getYears() {
        return years;
    }
}
