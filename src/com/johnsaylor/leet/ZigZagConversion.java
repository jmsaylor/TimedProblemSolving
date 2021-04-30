package com.johnsaylor.leet;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<Character>());
        }

        boolean isGoingUp = true;
        int rowIndex = 0;
        List<Character> row;


        for (Character c : s.toCharArray()) {
            row = rows.get(rowIndex);
            row.add(c);


            if (rowIndex == numRows - 1) {
                isGoingUp = false;
            } else if (rowIndex == 0) {
                isGoingUp = true;
            }

            if (isGoingUp) {
                rowIndex++;
            } else {
                rowIndex--;
            }
        }

        String result = "";

        for (List<Character> r : rows) {
            for (Character c : r) {
                result = result.concat(String.valueOf(c));
            }
        }

        return result;
    }
}
