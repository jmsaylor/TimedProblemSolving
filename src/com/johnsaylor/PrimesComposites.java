package com.johnsaylor;

import java.util.Arrays;

public class PrimesComposites {
        public void test(){
            int[] test = new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
            solution(test);
        }

        public int solution(int[] A) {
            // write your code in Java SE 8
            System.out.println(Arrays.toString(A));
            int flagLimit = (int) Math.sqrt((double) A.length) + 2;
            int[] peaks = new int[A.length];

            int nextPeak = A.length;
            for(int i = A.length - 1; i >= 0; i--){
                int left = i - 1 < 0 ? 0 : A[i - 1];
                int right = i + 1 >= A.length ? 0 : A[i + 1];
                if (A[i] > left && A[i] > right) {
                    nextPeak = i;
                }
                peaks[i] = nextPeak;
            }

            System.out.println(Arrays.toString(peaks));
            while (!(canPlace(flagLimit, peaks))) {
                System.out.println("check " + flagLimit);
                flagLimit--;
            }

            return flagLimit;
        }

        boolean canPlace(int flags, int[] peaks) {
            int i = 0;
            int peak = peaks[0];
            int result = flags;
            while (peak < peaks.length){
                result--;
                System.out.print(peak + " ");
                if (peak + 5 > peaks.length) break;
                peak = peaks[ peak + 5 ];
            }
            System.out.println(result);
            return result == 0;
        }

    }

