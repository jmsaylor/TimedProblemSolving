package com.johnsaylor.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {

    }

    public List<List<Integer>> assumedSubSequence(int[] nums) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            String string = "";
            int j = i;
            while (j < nums.length) {
                string = string.concat(String.valueOf(nums[j]));
                set.add(string);
                j++;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (String string : set) {
            List<Integer> subset = new ArrayList<>();
            for (char c : string.toCharArray()) {
                subset.add(Integer.parseInt(String.valueOf(c)));
            }
            result.add(subset);
        }

        return result;

    }
}
