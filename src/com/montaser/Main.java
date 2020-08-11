package com.montaser;

import jdk.swing.interop.SwingInterOpUtils;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = (int) askNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) askNumber("Annual rate: ", 1, 30);
        byte years = (byte) askNumber("years: ", 1, 30);

        printMortgage(principal, annualInterest, years);
        printRemaining(principal, annualInterest, years);
    }

    private static void printRemaining(int principal, float annualInterest, byte years) {
        System.out.println("REMAINING BALANCE: ");
        for (int i = 1; i <= (years * 12); i++) {
            double remainingBalance = calculateRemainin(principal, i, annualInterest, years);
            String remainingFormatted = NumberFormat.getCurrencyInstance().format(remainingBalance);
            System.out.println(remainingFormatted);
        }
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage payment: " + mortgageFormatted);
        System.out.println("------------");
    }

    public static double calculateRemainin(int principal, int month, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double remainingAmount = principal *
                (Math.pow((1 + monthlyInterest), numberOfPayments) - (Math.pow((1 + monthlyInterest), month))) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1 );

        return remainingAmount;
    }

    public static double askNumber (String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
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
}