package com.montaser;

import java.text.NumberFormat;

public class MortgageReport {

    private static MortgageCalculator calculator;

    public static void printMortgage(int principal, float annualInterest, byte years) {
        calculator = new MortgageCalculator(principal, annualInterest, years);
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage payment: " + mortgageFormatted);
        System.out.println("------------");
    }

    public static void printRemaining(int principal, float annualInterest, byte years) {
        System.out.println("REMAINING BALANCE: ");
        for (int i = 1; i <= (years * 12); i++) {
            double remainingBalance = MortgageCalculator.calculateRemainin(i);
            String remainingFormatted = NumberFormat.getCurrencyInstance().format(remainingBalance);
            System.out.println(remainingFormatted);
        }
    }
}
