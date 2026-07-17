package com.satyam.leetcode.interview150.array;
// starting from end can you reach start
public class JumpGame {
    public boolean canJump(int[] nums){ //beautiful solution
        int goal = nums.length-1;
        for(int i = nums.length-2; i >= 0; i--){
            if(i+nums[i] >= goal)
                goal = i;
        }
        return goal == 0;
    }
}
