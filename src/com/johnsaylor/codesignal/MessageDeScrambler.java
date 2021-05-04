package com.johnsaylor.codesignal;

import java.util.*;

public class MessageDeScrambler {

    public static void main(String[] args){
        int[] seq = new int[]{1, 1, 0, 0, 0, 2, 2, 2};
        char[] chars = new char[]{'+', '+', 'A', 'A', 'B', '#', '#', '#'};
        int n = 3;

        System.out.println(packetDescrambler(seq, chars, n));


    }

    static String packetDescrambler(int[] seq, char[] fragmentData, int n) {
        HashMap<Integer, HashMap<Character, Integer>> occurrences = new HashMap<>();

        for (int i = 0; i < seq.length; i++) {
            if (!occurrences.containsKey(seq[i])) {
                occurrences.put(seq[i], new HashMap<>());
            }

            HashMap<Character, Integer> received = occurrences.get(seq[i]);

            if (received.containsKey(fragmentData[i])) {
                int temp = received.get(fragmentData[i]);
                received.put(fragmentData[i], ++temp);
            } else {
                received.put(fragmentData[i], 1);
            }

//            occurrences.put(seq[i], received);
        }

        System.out.println(occurrences.size());

        char[] result = new char[occurrences.size() - 1];

        float threshold = n / (float) 2;

        for (Map.Entry<Integer, HashMap<Character, Integer>> set : occurrences.entrySet()) {
            int charIndex = set.getKey();
            HashMap<Character, Integer> candidates = set.getValue();
            char charLeader = 0;
            int maxCount = 0;
            for (Map.Entry<Character, Integer> chars : candidates.entrySet()) {
                if (chars.getValue() > maxCount) {
                    maxCount = chars.getValue();
                    charLeader = chars.getKey();
                }
            }
            if (maxCount > threshold) {
                if (charLeader == '#') continue;
                result[charIndex] = charLeader;
            } else {
                return "";
            }
        }

//        System.out.println(result);
        String message = "";

        for (char c : result) {
            message = message.concat(String.valueOf(c));
        }

        return message;
    }

}
