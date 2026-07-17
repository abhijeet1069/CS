package com.satyam.leetcode.contest.virtual1;

public class ConcatWithReverse {
    public int[] concatWithReverse(int[] nums) {
        int[] res = new int[nums.length*2];
        for(int i = 0;i < nums.length; i++)
            res[i] = nums[i];
        for(int i = nums.length; i < res.length; i++)
            res[i] = res[res.length - i - 1];
        return res;
    }
}
