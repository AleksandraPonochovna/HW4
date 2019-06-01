package com.company;

import java.lang.CharSequence;

public class AsciiCharSequenceApp implements CharSequence {

    public static byte[] arrayByte = {110, 117, 110, 120, 88, 99, 65};

    AsciiCharSequenceApp(byte[] arrayByte) {
        this.arrayByte = arrayByte;
    }

    public static void main(String[] args) {
        int index = 4;
        int start = 1;
        int end = 5;
        AsciiCharSequenceApp main = new AsciiCharSequenceApp(arrayByte);
        System.out.println("Length of array: " + main.length());
        System.out.println("Element under index " + index + ": " + main.charAt(index));
        System.out.println("Convert byte array to string: " + main.toString());
        System.out.print("Sequence from " + start + " to " + end + ": " + main.subSequence(start, end));
    }

    public int length() {
        return arrayByte.length;
    }

    public CharSequence subSequence(int start, int end) {
        byte[] newArrayByte = new byte[end - start];
        int counter = 0;
        if (end > start) {
            for (int i = start; i < end; i++, counter++) {
                newArrayByte[counter] = arrayByte[i];
            }
        }
        return new AsciiCharSequenceApp(newArrayByte);
    }

    public char charAt(int index) {
        return (char) arrayByte[index];
    }

    public String toString() {
        String string = new String(this.arrayByte);
        return string;
    }
}
