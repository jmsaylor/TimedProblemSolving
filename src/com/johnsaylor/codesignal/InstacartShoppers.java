package com.johnsaylor.codesignal;

public class InstacartShoppers {

    boolean[] delivery(int[] order, int[][] shoppers) {
        boolean[] result = new boolean[shoppers.length];

        int distanceToDelivery = order[0];
        float startTimeWindow = order[1];
        float endTimeWindow = startTimeWindow + order[2];

        int[] shopper;
        int distanceToStore = 0;
        float speed = 0;
        int timeInStore = 0;


        float timeToComplete = 0;

        for (int i = 0; i < shoppers.length; i++) {
            shopper = shoppers[i];
            distanceToStore = shopper[0];
            speed = shopper[1];
            timeInStore = shopper[2];

            timeToComplete = ((distanceToDelivery + distanceToStore) / speed) + timeInStore;

            result[i] = (timeToComplete >= startTimeWindow && timeToComplete <= endTimeWindow);
        }

        return result;
    }
}
