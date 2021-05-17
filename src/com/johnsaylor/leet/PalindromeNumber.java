package com.johnsaylor.leet;

public class PalindromeNumber {

    //TODO: bitwise solution

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
