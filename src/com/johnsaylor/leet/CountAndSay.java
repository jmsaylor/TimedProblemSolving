package com.johnsaylor.leet;

public class CountAndSay {
    public String countAndSay(int n) {
        // if n == 1, return "1";
        if (n == 1) return "1";
        // return say(countAndSay(n - 1))
        return say(countAndSay(n - 1));
    }

    // String say(String string)
    String say(String string) {
        // Initialize count = 0
        int count = 0;
        // Initialize currentNumber to first character of string
        char currentNumber = string.charAt(0);
        // Initialize newString = ""
        String newString = "";
        // iterate through chars of string
        for (char currentChar : string.toCharArray()) {
            //if currentChar == currentNumber
            if (currentChar == currentNumber) {
                // count++
                count++;
            } else {
                //else
                // add String value of count and String value of currentNumber to newString
                newString = newString.concat(String.valueOf(count) + String.valueOf(currentNumber));
                // currentNumber = currentChar
                currentNumber = currentChar;
                // count = 1
                count = 1;

            }
        }


        // add String value of count and String value of currentNumber to newString
        newString = newString.concat(String.valueOf(count) + String.valueOf(currentNumber));
        // return newStringint count = 0
        return newString;
    }
}
