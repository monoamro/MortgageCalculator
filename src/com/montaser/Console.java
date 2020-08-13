package com.montaser;

import java.util.Scanner;

public class Console {
    public static double askNumber(String prompt, int min, int max) {
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
}
