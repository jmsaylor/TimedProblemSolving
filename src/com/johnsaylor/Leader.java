package com.johnsaylor;

import java.util.Arrays;

public class Leader {

    public static void test() {
        System.out.println(solution(new int[]{3,0,1,1,4,1,1}));
    }

    public static int solution(int[] A){
        int candidate = 0;
        int consecutiveCount = 0;

        for (int num : A) {
            if (consecutiveCount == 0) {
                candidate = num;
                consecutiveCount = 1;
            } else if (num == candidate) {
                consecutiveCount++;
            } else {
                consecutiveCount--;
            }
        }

        int occurence = 0;
        int index = 0;

        for (int i = 0; i < A.length; i++) {
            if (candidate == A[i]){
                occurence++;
                index = i;
            }
        }

        return occurence > A.length / 2 ? index : -1;
    }

}
