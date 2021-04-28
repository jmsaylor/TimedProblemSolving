package com.johnsaylor.codesignal;

import java.util.HashMap;

public class SpaceXLaunchSequence {

    public static void main(String[] args) {
        System.out.println(launchSequenceChecker(null, null));
    }

    static boolean launchSequenceChecker(String[] systemNames, int[] stepNumbers) {
        if (systemNames == null || stepNumbers == null || systemNames.length != stepNumbers.length) return false;

        HashMap<String, Integer> previousSequence = new HashMap<>();

        for (int i = 0; i < stepNumbers.length; i++) {
            String name = systemNames[i];
            int step = stepNumbers[i];
            if (!previousSequence.containsKey(name)) {
                previousSequence.put(name, step);
            } else {
                int previous = previousSequence.get(name);
                if (previous >= step) {
                    return false;
                }
                previousSequence.put(name, step);
            }
        }

        return true;
    }
}
