package com.johnsaylor.codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {

    public int solution(String S) {
        // write your code in Java SE 8
        Deque<Character> stack = new ArrayDeque();
        for (char c : S.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) return 0;
                char popped = stack.removeLast();
                if (    (c == ')' && popped != '(') ||
                        (c == ']' && popped != '[') ||
                        (c == '}' && popped != '{'))
                {
                    return 0;
                }
            }
        }
        return (stack.isEmpty() ? 1 : 0);
    }
}
