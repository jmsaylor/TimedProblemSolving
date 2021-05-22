package com.johnsaylor.leet;

public class MaxContainer {

    public int maxArea(int[] height) {
        int maxVolume = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                maxVolume = Math.max((j - i) * Math.min(height[i], height[j]), maxVolume);

            }
        }

        return maxVolume;
    }
}
