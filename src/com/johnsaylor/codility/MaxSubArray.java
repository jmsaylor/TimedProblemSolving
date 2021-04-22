package com.johnsaylor.codility;

public class MaxSubArray {

    public static void test() {
        System.out.println(solution(new int[]{100,110,120, 100, 110, 130}));
    }

    public static int solution(int[] A){
        //Kadane's algo
        int localMax = 0;
        int globalMax = 0;

        for (int i = 1 ; i < A.length; i++) {
            int delta = A[i] - A[i -1];
            localMax = Math.max(delta, localMax + delta);
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;

    }
}
