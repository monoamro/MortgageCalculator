package com.montaser;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.askNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.askNumber("Annual rate: ", 1, 30);
        byte years = (byte) Console.askNumber("years: ", 1, 30);

        MortgageReport.printMortgage(principal, annualInterest, years);
        MortgageReport.printRemaining(principal, annualInterest, years);
    }

}
