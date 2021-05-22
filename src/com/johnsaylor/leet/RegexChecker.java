package com.johnsaylor.leet;

import java.util.regex.Pattern;

public class RegexChecker {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).matches();
    }
}
