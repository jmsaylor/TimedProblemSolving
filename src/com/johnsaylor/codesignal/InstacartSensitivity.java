package com.johnsaylor.codesignal;

public class InstacartSensitivity {
    public static void main(String[] args) {
        double[] prices = new double[]{110, 95, 70};

        String[] notes = new String[]{"10.0% higher than in-store",
                "5.0% lower than in-store",
                "Same as in-store"};

        isAdmissibleOverpayment(prices, notes, 5);
    }


    static boolean isAdmissibleOverpayment(double[] prices, String[] notes, double x) {
        // define variable for difference as double
        double sensitivity = 0d;


        // FOR price in prices
        for (int i = 0; i < prices.length; i++) {
            // get price and corresponding note
            String note = notes[i];
            double instaPrice = prices[i];

            // if same price, no impact on sensitivity
            if (note.startsWith("Same")) continue;

            // grab corresponding percentage from String in index in notes
            int cutIndex = note.indexOf("%");
            double percentage = Double.parseDouble(note.substring(0,cutIndex));
            percentage = percentage / 100;

            // determine if in-store price is lower or higher than Instacart price
            if (note.contains("lower")) {
                // if Instacart price is lower then it decreases sensitivity
                sensitivity = sensitivity - ((instaPrice / (1 - percentage)) - instaPrice);

            } else {
                // if Instacart price is higher then it increases sensitivity
                sensitivity = sensitivity + (instaPrice - (instaPrice / (1 + percentage)));

            }
        }

        // return difference < x, be careful of clipped data
        return (float) sensitivity < x;
    }

}
