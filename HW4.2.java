package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        number = input.nextInt();
        System.out.print("Factorial of number: " + factorial(number));
    }

    public static BigInteger factorial(int number) {
        BigInteger factorial = new BigInteger("1");
        BigInteger initialNumber = BigInteger.valueOf(number + 1);
        BigInteger i;
        for (i = BigInteger.ONE; !i.equals(initialNumber); i = i.add(BigInteger.ONE)) {
            factorial = factorial.multiply(i);
        }
        return factorial;
    }
}
