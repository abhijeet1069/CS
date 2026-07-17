package com.satyam.leetcode.interview150.array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 1;i < nums.length; i++){
            if(nums[i] != nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }
}
