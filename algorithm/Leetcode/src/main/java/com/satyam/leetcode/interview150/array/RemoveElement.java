package com.satyam.leetcode.interview150.array;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int itemsToConsider = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[itemsToConsider] = nums[i];
                itemsToConsider++;
            }
        }
        return itemsToConsider;
    }
}