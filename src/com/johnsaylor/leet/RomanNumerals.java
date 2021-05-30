package com.johnsaylor.leet;

public class RomanNumerals {
    public static void main(String[] args) {
        System.out.println(intToRoman(58));

    }

    public static void test(int n) {
        String nString = String.valueOf(n);
        String thousands =  nString.length() > 3 ? nString.substring(0, nString.length() - 3) : "";
        String hundreds = nString.length() > 2 ? nString.substring(nString.length() - 3, nString.length() - 2) : "";
        String tens = nString.length() > 1 ? nString.substring(nString.length() - 2, nString.length() - 1) : "";
        String ones = nString.length() > 0 ? nString.substring(nString.length() - 1) : "";
    }
    public static String intToRoman(int num) {

        String nString = String.valueOf(num);
        String thousands =  nString.length() > 3 ? nString.substring(0, nString.length() - 3) : "";
        String hundreds = nString.length() > 2 ? nString.substring(nString.length() - 3, nString.length() - 2) : "";
        String tens = nString.length() > 1 ? nString.substring(nString.length() - 2, nString.length() - 1) : "";
        String ones = nString.length() > 0 ? nString.substring(nString.length() - 1) : "";

        return thousands(thousands) + hundreds(hundreds) + tens(tens) + ones(ones);
    }

    static String thousands(String n) {
        String result = "";
        if (n.isBlank()) return result;
        for (int i = 0; i < Integer.parseInt(n) ; i++) {
            result = result.concat("M");
        }

        return result;
    }

    static String hundreds(String n) {
        String result = "";
        if (n.isBlank()) return result;
        int value = Integer.parseInt(n);

        if (value == 9) {
            result = "CM";
        } else if (value == 4) {
            result = "CD";
        } else {
            if (value >= 5) {
                result = "D";
                value = value - 5;
            }
            for (int i = 0; i < value; i++) {
                result = result.concat("C");
            }
        }

        return result;
    }

    static String tens(String n) {
        String result = "";
        if (n.isBlank()) return result;
        int value = Integer.parseInt(n);


        if ( value == 9) {
            result = "XC";
        } else if ( value == 4) {
            result = "XL";
        } else {
            if (value >= 5) {
                result = "L";
                value = value - 5;
            }
            for (int i = 0; i < value; i++) {
                result = result.concat("X");
            }
        }

        return result;
    }

    static String ones(String n) {
        String result = "";
        if (n.isBlank()) return result;
        int value = Integer.parseInt(n);

        if (value == 9) {
            result = "IX";
        } else if (value == 4) {
            result = "IV";
        } else {
            if (value >= 5) {
                result = "V";
                value = value - 5;
            }
            for (int i = 0; i < value; i++) {
                result = result.concat("I");
            }
        }

        return result;
    }
}
