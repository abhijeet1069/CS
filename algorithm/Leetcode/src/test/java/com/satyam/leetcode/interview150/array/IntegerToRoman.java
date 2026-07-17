package com.satyam.leetcode.interview150.array;

import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hrns = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ths ={"","M","MM","MMM"};

        return new StringBuilder()
                .append(ths[num/1000])
                .append(hrns[(num%1000)/100])
                .append(tens[(num%100)/10])
                .append(ones[num%10])
                .toString();
    }
}
