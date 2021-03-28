package com.johnsaylor;

public class EuclideanChocolates {
    public int solution(int N, int M) {
        // write your code in Java SE 8
        return N / gcd(N, M);
    }

    int gcd(int N, int M){
        if (M == 0) return 0;
        return 1 + gcd(M, N % M);
    }
}
