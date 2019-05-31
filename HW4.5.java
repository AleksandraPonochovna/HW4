package com.company;

import java.util.Scanner;

public class SqrtApp {

    public static void main(String[] args) {
        SqrtApp start = new SqrtApp();
        Scanner input = new Scanner(System.in);
        double number = input.nextDouble();
        double result = start.sqrt(number);
        System.out.println(result);
    }

    public static double sqrt(double x) {
        double result = 1;
        double border = Math.max(1, x);
        double step = 1;
        if (x > 0) {
            for (double i = 0; i < border; i += step) {
                if (i * i >= x) {
                    border = i;
                    i = border - step;
                    step -= 0.05;
                }
            }
        } else {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return border;
    }
}
