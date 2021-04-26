package com.johnsaylor.leet;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabbaa"));
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean[][] table = new boolean[s.length()][s.length()];
        int[] maxPalindrome = {0, 0};


        for (int i = 0; i < table.length; i++) {
            table[i][i] = true;
        }

        for (int i = 0; i < table.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                table[i][i + 1] = true;
                maxPalindrome[0] = i;
                maxPalindrome[1] = i + 1;
            }
        }

        for (int length = 3; length <= table.length; length++) {
            int distance = length - 1;
            for (int i = 0; i + distance < table.length; i++) {
                if(chars[i] == chars[i + distance] && table[i + 1][i + distance - 1]) {
                      table[i][i + distance] = true;
                      if ((i + distance) - i > maxPalindrome[1] - maxPalindrome[0]) {
                          maxPalindrome[0] = i;
                          maxPalindrome[1] = i + distance;
                      }
                }
            }
        }

        for (boolean[] row : table) {
            System.out.println(Arrays.toString(row));
        }

        return s.substring(maxPalindrome[0], maxPalindrome[1] + 1);
    }

    public static String longestPalindrome2(String s) {
        if (s.length() == 0) return "";
        char[] chars = s.toCharArray();
        String maxSubstring = s.substring(0,1);

        for (int i = 0; i < chars.length; i++) {
            int end = s.lastIndexOf(chars[i]);
            while (end > i) {
                if (end - i < maxSubstring.length()) break;
                System.out.println(chars[i] + ": " + i + " : " + end);
                boolean isPalindrome = true;
                for (int j = 0; i + j <= end - ((end - i) / 2); j++) {
                    if (chars[i + j] != chars[end - j]) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    maxSubstring = s.substring(i, end + 1);
                    break;
                }
                end = s.lastIndexOf(chars[i], end - 1);
            }
        }

        return maxSubstring;
    }

}
