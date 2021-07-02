package com.johnsaylor.apple;

import java.util.Arrays;

public class ReverseSquares {

    public static void main(String[] args) {
        int[] arr = new int[]{-8, -2, -1, 0, 4, 5};
        System.out.println(Arrays.toString(solve(arr)));
    }

    public static int[] solve(int[] arr) {
        int[] result = new int[arr.length];

        int i = 0;
        int j = arr.length - 1;


        for (int k = 1; k <= arr.length; k++) {

            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[arr.length - k] = (int) Math.pow(arr[i], 2);
                i++;
            } else {
                result[arr.length - k] = (int) Math.pow(arr[j], 2);
                j--;
            }
        }

        return result;
    }
}
