package com.johnsaylor.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctSlices {

    public static void test(){
       int result = solution(6, new int[]{3, 4, 5, 5, 2});
        System.out.println(result);
    }

    static int solution(int M, int[] A) {
        // write your code in Java SE 8
        if (M > 1_000_000_000) return 1_000_000_000;


        int count = 0;
        Set<Integer> set = new HashSet<>();
        int front = 0;
        int back = 0;

        System.out.println(Arrays.toString(A));

        while (front < A.length){
            if (set.contains(A[front])) {
                set.remove(A[back]);
                back++;
            } else {
                set.add(A[front]);
                count = count + ((front - back) + 1);
                front++;
            }

        }

        return count;

    }
}
