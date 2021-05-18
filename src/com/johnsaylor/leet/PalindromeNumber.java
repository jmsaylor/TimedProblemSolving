package com.johnsaylor.leet;

import java.util.regex.Pattern;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println( isPalindrome(18081));
    }

    //TODO: bitwise solution

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        String string = String.valueOf(x);
        StringBuilder firstHalf  = new StringBuilder(string.substring(0, string.length() / 2));

        Pattern pattern = Pattern.compile(firstHalf.reverse().toString());

        int startSecondHalf = string.length() % 2 == 0 ? string.length() / 2 : string.length() / 2 + 1;

        return pattern.matcher(string.substring(startSecondHalf)).matches();

    }

    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String string = String.valueOf(x);
        int length = string.length();
        char[] chars = string.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - (i + 1)]) {
                return false;
            }
        }

        return true;

    }

    public boolean isPalindrome0(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String string = String.valueOf(x);
        int length = string.length();


        for (int i = 0; i < length / 2; i++) {
            if (string.charAt(i) != string.charAt(length - (i + 1))) {
                return false;
            }
        }

        return true;

    }
}
