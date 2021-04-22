package com.johnsaylor.codility;

import java.util.Arrays;

public class TapeEquilibrium {
    public static void test() {
        System.out.println(improvements(new int[]{3,1,2,4,3}));
    }
    public static int submission(int[] A) {
        // write your code in Java SE 8
        int left = A[0];
        int right = Arrays.stream(A).sum() - left;
        int minDifference = Integer.MAX_VALUE;

        for (int i = 1; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            minDifference = Math.min(minDifference, Math.abs(left - right));
        }
        return minDifference;
    }

    public static int improvements(int[] A) {
        // write your code in Java SE 8
        long left = A[0];
        long right = Arrays.stream(A).sum() - left;
        long minDifference = Math.abs(left - right);

        for (int i = 1; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            long currentDifference = Math.abs(left - right);
            minDifference = Math.min(minDifference, currentDifference);
        }
        return (int) minDifference;
    }
}
