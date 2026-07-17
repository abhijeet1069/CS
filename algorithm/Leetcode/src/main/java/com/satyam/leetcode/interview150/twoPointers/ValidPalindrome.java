package com.satyam.leetcode.interview150.twoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String normalisedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l = 0, r = normalisedStr.length()-1;
        boolean isPalindrome = true;
        while(l < r){
            if(normalisedStr.charAt(l) != normalisedStr.charAt(r)){
                isPalindrome = false;
                break;
            }
            l++;
            r--;
        }
        return isPalindrome;
    }
}
