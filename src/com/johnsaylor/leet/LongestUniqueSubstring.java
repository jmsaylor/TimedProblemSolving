package com.johnsaylor.leet;

import java.util.HashSet;

public class LongestUniqueSubstring {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<Character>();
        int maxLength = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (set.contains(chars[j])) break;
                set.add(chars[j]);
            }
            maxLength = Math.max(maxLength, set.size());
            set.clear();
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 1) return 1;


        HashSet<Character> set = new HashSet<Character>();
        int maxLength = 0;

        for (char c : s.toCharArray()){
            if (set.contains(c)) {
                maxLength = Math.max(maxLength, set.size());
                set.clear();
            }
            set.add(c);
            System.out.println(set);
        }
        maxLength = Math.max(maxLength, set.size());
        return maxLength;
    }
}
