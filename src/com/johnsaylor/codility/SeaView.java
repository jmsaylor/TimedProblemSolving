package com.johnsaylor.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeaView {

    public static void test() {
        int[] locations = new int[]{4, 3, 2, 5, 3, 1};
        System.out.println(seaView2(locations));
        System.out.println(seaView(locations));
    }

    public static List<Integer> seaView2(int[] locations) {
        List<Integer> floorsWithSeaView = new ArrayList<>();

        for (int building = locations.length - 1; building >= 0; building--) {
            if (locations[building] > floorsWithSeaView.size()) {
                for (int floor = 0; floor <= locations[building] - floorsWithSeaView.size(); floor++){
                    floorsWithSeaView.add(building);
                }
            }
        }

        Collections.reverse(floorsWithSeaView);

        return floorsWithSeaView;
    }

    public static List<Integer> seaView(int[] locations) {
        List<Integer> floorsWithSeaView = new ArrayList<>(locations[0]);
        for (int floor = 0; floor < locations[0]; floor++) floorsWithSeaView.add(0);

        for (int building = 0; building < locations.length; building++) {

            if (locations[building] > floorsWithSeaView.size()) {

                floorsWithSeaView = new ArrayList(locations[building]);

                for (int floor = 0; floor < locations[building]; floor++) floorsWithSeaView.add(building);

            } else {

                for (int floor = 0; floor < locations[building]; floor++) floorsWithSeaView.set(floor, building);
            }
        }

        Collections.reverse(floorsWithSeaView);

        return floorsWithSeaView;
    }


}
