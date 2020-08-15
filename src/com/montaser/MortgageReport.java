package com.montaser;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println("Mortgage payment: " + mortgageFormatted);
        System.out.println("------------");
    }

    public void printRemaining() {
        System.out.println("REMAINING BALANCE: ");
        for (double balance : calculator.getRemainingBalance()) {
            String balanceFormatted = currency.format(balance);
            System.out.println(balanceFormatted);
        }
    }
}
