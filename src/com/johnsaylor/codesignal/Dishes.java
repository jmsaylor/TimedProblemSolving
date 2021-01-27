package com.johnsaylor.codesignal;

import java.util.*;

public class Dishes {
    String[][] groupingDishes(String[][] dishes) {
        Map<String, List<String>> hashTable = new HashMap<>();

        for (String[] dish : dishes) {
            for (int i = 1; i < dish.length; i++) {
                String ingredient = dish[i];
                if (!(hashTable.containsKey(ingredient))) {
                    List<String> dishValues = new ArrayList<>();
                    dishValues.add(dish[0]);
                    hashTable.put(ingredient, dishValues);
                } else {
                    List<String> dishValues = hashTable.get(ingredient);
                    dishValues.add(dish[0]);
                    hashTable.put(ingredient, dishValues);
                }
            }
        }

        Object[] keys = hashTable.keySet().toArray();
        keys = Arrays.stream(keys).filter(x -> hashTable.get(x).size() >= 2).toArray();
        String[][] result = new String[keys.length][];

        for (int i = 0; i < keys.length; i++) {
            String ingredient = keys[i].toString();
            List<String> dishValues = hashTable.get(ingredient);
            result[i] = new String[dishValues.size() + 1];
            result[i][0] = ingredient;

            for (int j = 0; j < dishValues.size(); j++) {
                result[i][j + 1] = dishValues.get(j);
            }

        }

        Arrays.sort(result, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return a[0].compareTo(b[0]);
            }
        });

        for (var e : result) {
            Arrays.sort(e, 1, e.length);
        }

        return result;
}
