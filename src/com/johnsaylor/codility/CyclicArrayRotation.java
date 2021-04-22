package com.johnsaylor.codility;

import java.util.Arrays;

public class CyclicArrayRotation {

    public static void test() {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3}, 2)));

    }

    public static int[] solution(int[] A, int K){
        int[] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            result[((i + K) % A.length)] = A[i];
        }
        return result;
    }

    public static int[] improvements(int[] A, int K) {

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[((i + K) % A.length)];
        }

        return result;
    }

    public static int[] submission(int[] A, int K) {

        int[] result = new int[A.length];
        int marker = K >= A.length ? K - ((K / A.length) * A.length) : K - 1;
        if (K == 0 || marker == 0 || A.length == 0) return A;

        for (int i = 0; i < A.length; i++) {
            if (marker >= A.length) {
                result[i] = A[marker - A.length];
            } else {
                result[i] = A[marker];
            }
            marker++;
        }

        return result;
    }
}
