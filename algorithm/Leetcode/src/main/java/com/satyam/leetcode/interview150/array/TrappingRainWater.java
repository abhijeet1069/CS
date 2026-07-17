package com.satyam.leetcode.interview150.array;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] l = new int[height.length];
        int max = height[0];
        for(int i = 1; i < height.length; i++){
            if(max > height[i])
                l[i] = max;
            else
                max = height[i];
        }

        int[] r = new int[height.length];
        max = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--){
            if(max > height[i])
                r[i] = max;
            else
                max = height[i];
        }

        int[] res = new int[height.length];
        for(int i = 0;i < height.length; i++){
            int water = Math.min(l[i],r[i])-height[i];
            if(water < 0)
                res[i] = 0;
            else
                res[i] = water;
        }

        int sum = 0;
        for(int x : res)
            sum += x;

        return sum;
    }
}
