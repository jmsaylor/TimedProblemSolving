package com.johnsaylor.codility;

public class GreedyRopes {
    public int solution(int K, int[] A) {
        // write your code in Java SE 8

        int ropes = 0;
        int currentLength = 0;

        for (int rope : A){
            currentLength+=rope;
            if (currentLength >= K) {
                ropes++;
                currentLength = 0;
            }
        }
        return ropes;
    }
}
