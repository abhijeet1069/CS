package com.satyam.leetcode.interview150.twoPointers;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0, r = numbers.length-1;
        while(l < r){
            int temp = numbers[l]+numbers[r];
            if(temp == target){
                res[0] = l+1;
                res[1] = r+1;
                return res;
            }
            else if(temp > target)
                r--;
            else
                l++;
        }
        return res;
    }
}
