package com.johnsaylor;

import java.util.Arrays;

public class MaxCounters {

    public static void test() {
        System.out.println(Arrays.toString(solution( 5, new int[]{3,4,4,6,1,4,4})));
    }

    public static int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];
        int maxCounter = 0;
        int startLine = maxCounter;
        Arrays.fill(result, startLine);

        for (int num : A) {
            int index = num - 1;
            if (num > N) {
                startLine = maxCounter;
            } else if (result[index] < startLine) {
                result[index] = startLine + 1;
            } else {
                result[index]++;
            }

            if (num < N) maxCounter = Math.max(maxCounter, result[index]);
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] < startLine) {
                result[i] = startLine;
            }
        }

        return result;
    }
}
