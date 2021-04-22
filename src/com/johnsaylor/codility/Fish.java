package com.johnsaylor.codility;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Fish {

    public static void test() {
        solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0});
    }

    public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        Deque<Integer> stack = new ArrayDeque<>();
        int survivors = 0;

        for (int i = 0; i < B.length; i++) {
            if (B[i] == 1){
                stack.addLast(A[i]);
            } else {
                while (!stack.isEmpty() && stack.peekLast() < A[i]) stack.removeLast();
                if (stack.isEmpty()) survivors++;
            }
            System.out.println(stack + "   " + survivors);
        }
        return survivors + stack.size();

    }
}
