package com.satyam.leetcode.interview150.array;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minWordLen = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            if(minWordLen > strs[i].length())
                minWordLen =  strs[i].length();
        }
        StringBuilder commPrefix = new StringBuilder();
        for(int i = 0; i < minWordLen; i++){
            char firstChar = strs[0].charAt(i);
            boolean same = true;
            for(int j = 1; j < strs.length; j++){
                if(firstChar != strs[j].charAt(i)){
                    same = false;
                    break;
                }
            }
            if(same)
                commPrefix.append(firstChar);
            else
                break; //stop comparing once found not equal character
        }
        return commPrefix.toString();
    }
}
