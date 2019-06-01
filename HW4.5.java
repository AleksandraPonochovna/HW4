package com.company;

import java.util.Scanner;

public class SqrtApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double number = input.nextDouble();
        double result = sqrt(number);
        System.out.println(result);
    }

    public static double sqrt(double x) {
        if (x > 0) {
            x = Math.sqrt(x);
        } else {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return x;
    }
}
