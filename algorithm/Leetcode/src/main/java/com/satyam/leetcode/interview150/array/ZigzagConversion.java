package com.satyam.leetcode.interview150.array;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length())
            return s;

        StringBuilder[] arr = new StringBuilder[numRows];
        for(int i = 0; i < arr.length; i++)
            arr[i] = new StringBuilder();

        boolean goDown = false;
        int index = 0;
        for(char ch : s.toCharArray()){
            if(index == 0 || index == numRows-1)
                goDown = !goDown;

            arr[index].append(ch);
            index += goDown? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0;i < arr.length; i++)
            res.append(arr[i]);

        return res.toString();
    }
}
