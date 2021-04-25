package com.johnsaylor.leet;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {
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
