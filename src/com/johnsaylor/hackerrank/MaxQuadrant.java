package com.johnsaylor.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MaxQuadrant {

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(112, 42, 83, 119));
        matrix.add(List.of(56, 125, 56, 49));
        matrix.add(List.of(15, 78, 101, 43));
        matrix.add(List.of(62, 98, 114, 108));

        System.out.println(flippingMatrix(matrix));
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        //Initialize totalSum to zero
        int totalSum = 0;

        //FOR each cell in upper left quadrant
        for (int i = 0; i < matrix.size() / 2; i++) {
            for (int j = 0; j < matrix.size() / 2; j++) {
                // collect mirrors in all quadrants
                int upperLeft = matrix.get(i).get(j);
                int upperRight = matrix.get(i).get(matrix.size() - (j + 1));
                int lowerLeft = matrix.get(matrix.size() - (i + 1)).get(j);
                int lowerRight = matrix.get(matrix.size() - (i + 1)).get(matrix.size() - (j + 1));
                // add greatest of them to totalSum

                totalSum += Math.max(Math.max(upperLeft, upperRight), Math.max(lowerLeft, lowerRight));

            }
        }

        //RETURN totalSum
        return totalSum;

    }

}
