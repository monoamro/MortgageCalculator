package com.montaser;

import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);

    public static double askNumber(String prompt) {
        System.out.println(prompt);
        double value = scanner.nextDouble();
        return value;
    }

    public static double askNumber(String prompt, int min, int max) {
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
}
