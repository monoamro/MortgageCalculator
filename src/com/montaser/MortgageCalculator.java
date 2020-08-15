package com.montaser;

import java.text.NumberFormat;

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
        int numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    public double calculateRemainin(int month) {
        double remainingAmount = principal *
                (Math.pow((1 + getMonthlyInterest()), getNumberOfPayments()) - (Math.pow((1 + getMonthlyInterest()), month))) /
                (Math.pow((1 + getMonthlyInterest()), getNumberOfPayments()) - 1);
        return remainingAmount;
    }

    public double[] getRemainingBalance() {
        var balances = new double[getNumberOfPayments()];
        for (short i = 1; i <= balances.length; i++)
            balances[i - 1] = calculateRemainin(i);
        return balances;
    }

    public int getYears() {
        return years;
    }
}
