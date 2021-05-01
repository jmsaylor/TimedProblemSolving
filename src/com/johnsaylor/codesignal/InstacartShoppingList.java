package com.johnsaylor.codesignal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstacartShoppingList {

    public static void main(String[] args){
        System.out.println(shoppingList("wanna 22.2&15.3olo 0.00 and 12.12kk0.02 ..34"));
    }

    static double shoppingList(String items) {
        double result = 0;
        List<Double> prices = new ArrayList<>();
        Matcher matcher = Pattern.compile("[0-9]*[.]?[0-9]*").matcher(items);

        while (matcher.find()) {
            String price = matcher.group();

            if (!price.isBlank() && !price.equals(".")) {
                if (price.startsWith(".")) {
                    price = price.substring(1);
                }
                prices.add(Double.valueOf(price));
            }
        }

        for (Double price : prices) {
            result += price;
        }

        System.out.println(prices);
        return result;
    }
}
