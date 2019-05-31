package com.company;

public class AsciiCharSequence implements java.lang.CharSequence {

    public static byte[] arrayByte = {110, 117, 110, 120, 88, 99, 65};

    AsciiCharSequence(byte[] arrayByte) {
        this.arrayByte = arrayByte;
    }

    public static void main(String[] args) {
        int index = 4;
        int start = 1;
        int end = 5;
        AsciiCharSequence main = new AsciiCharSequence(arrayByte);
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
        if (start == end) {
            return null;
        } else {
            for (int i = start; i < end; i++) {
                newArrayByte[counter] = arrayByte[i];
                counter++;
            }
        }
        return new AsciiCharSequence(newArrayByte);
    }

    public char charAt(int index) {
       return (char) arrayByte[index];
    }

    public String toString() {
        String string = new String(this.arrayByte);
        return string;
    }
}
