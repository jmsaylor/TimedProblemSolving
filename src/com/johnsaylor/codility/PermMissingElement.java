package com.johnsaylor.codility;

public class PermMissingElement {

    public static void test(){
        System.out.println(PermMissingElement.solutionSum(new int[]{1,3,2,5}));
        System.out.println(PermMissingElement.solutionTable(new int[]{1,3,2,5}));
    }

    public static int solutionSum(int[] arr) {
        int x = arr.length + 1;
        int triangularSum = (x * (x + 1)) / 2;
        System.out.println(triangularSum);
        for (int num : arr) {
            triangularSum -= num;
        }
        return triangularSum;
    }

    public static int solutionTable(int[] arr) {
        int x = arr.length + 1;
        boolean[] table = new boolean[x + 1];
        for (int num : arr){
            table[num] = true;
        }
        for (int i = 1; i < table.length; i++) {
            if (!table[i]) return i;
        }
        return 0;
    }
}
