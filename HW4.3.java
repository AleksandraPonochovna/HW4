package com.company;

public class Palindrom {

    public static void main(String[] args) {
        String userString = "Madam, I'm Adam.";
        if (isPalindrome(userString)) {
            System.out.print("This string is palindrom!");
        } else {
            System.out.print("This string isn't palindrom!");
        }
    }

    public static boolean isPalindrome(String text) {

        text = text.replaceAll("[^A-Za-z]", "");
        String invertedString = new StringBuffer(text).reverse().toString();
        return text.equalsIgnoreCase(invertedString);
    }
}
