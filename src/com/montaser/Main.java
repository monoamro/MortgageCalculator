package com.montaser;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.askNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.askNumber("Annual rate: ", 1, 30);
        byte years = (byte) Console.askNumber("years: ", 1, 30);

        MortgageReport.printMortgage(principal, annualInterest, years);
        MortgageReport.printRemaining(principal, annualInterest, years);
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    public static double calculateRemainin(int principal, int month, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double remainingAmount = principal *
                (Math.pow((1 + monthlyInterest), numberOfPayments) - (Math.pow((1 + monthlyInterest), month))) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);

        return remainingAmount;
    }
}
