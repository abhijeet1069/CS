package com.satyam.leetcode.interview150.slidingWindow;

public class MinSizeSubarray {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length+1;
        int len = 0;
        int l = 0;
        int sum = 0;
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            len++;
            while (sum >= target){
                minLen = Math.min(minLen,len);
                sum -= nums[l];
                l++;
                len--;
            }
        }
        if(minLen == nums.length+1)
            return 0;
        else
            return minLen;
    }
}
