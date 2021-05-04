package com.johnsaylor.leet;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    public static int reverse(int x) {
        StringBuilder xString = new StringBuilder(String.valueOf(x));

        xString.reverse();

        if (xString.charAt(xString.length() - 1) == '-') {
            xString.deleteCharAt(xString.length() - 1);
            xString.insert(0, '-');
        }

        int result;

        try {
            result = Integer.parseInt(xString.toString());
        } catch (Exception e) {
            return 0;
        }

        return result;

    }


}
