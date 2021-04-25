package com.johnsaylor.leet;

import java.util.Arrays;

public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    // TODO: find memory efficient solution where only middle item is kept

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = ((nums1.length + nums2.length) / 2) + 1;
        int[] result = new int[length];
        boolean isEven = ((nums1.length + nums2.length) % 2) == 0;

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < length; i++) {
            if (index1 >= nums1.length) {
                result[i] = nums2[index2++];
                continue;
            }
            if (index2 >= nums2.length) {
                result[i] = nums1[index1++];
                continue;
            }

            if (nums1[index1] < nums2[index2]) {
                result[i] = nums1[index1++];
            } else {
                result[i] = nums2[index2++];
            }
        }

        System.out.println(Arrays.toString(result));

        return ( isEven
                ? (result[length - 1] + result[length - 2]) / (double) 2
                : (double) result[length - 1] );
    }
}
