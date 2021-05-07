package com.johnsaylor.leet;

public class ATOI {

    public static void main(String[] args) {
        System.out.println(myAtoi(
                "+-12"));
    }

    static public int myAtoi(String s) {

            if (s.length() < 1) return 0;
            String tempResult = "";
            int index = 0;
            boolean isPositive = true;
            //remove whitespace
            while (index < s.length() && s.charAt(index) == ' ') index++;
            //determine positive or negative

            if (index >= s.length()) return 0;

            if (s.charAt(index) == '+' || s.charAt(index) == '-'){
                if (s.charAt(index) == '-') {
                    isPositive = false;
                }
                index ++;
            }


            if (index >= s.length() || !Character.isDigit(s.charAt(index))) return 0;

            //grab numbers or return 0 if non-numeric, terminate once first number is over

            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                tempResult = tempResult.concat(String.valueOf(s.charAt(index)));
                index++;
            }

            //see if parsed number out of 32-bit int bounds, assign min or max int value if it is based on sign
            // and return it
            if (tempResult.equals("0") || tempResult.isEmpty()) {
                return 0;
            }

            if(!isPositive) {
                tempResult = "-".concat(tempResult);
            }


            try {
                return Integer.parseInt(tempResult);
            } catch (Exception e) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

        }
}
