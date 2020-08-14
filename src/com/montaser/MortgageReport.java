package com.montaser;

import java.text.NumberFormat;

public class MortgageReport {


    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage payment: " + mortgageFormatted);
        System.out.println("------------");
    }

    public void printRemaining() {
        System.out.println("REMAINING BALANCE: ");
        for (int i = 1; i <= (calculator.getYears() * 12); i++) {
            double remainingBalance = calculator.calculateRemainin(i);
            String remainingFormatted = NumberFormat.getCurrencyInstance().format(remainingBalance);
            System.out.println(remainingFormatted);
        }
    }
}
