package com.satyam.leetcode.interview150.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int goal = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == goal) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // skip duplicates
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if (sum < goal) {
                    l++;  // need bigger sum
                }
                else {
                    r--;  // need smaller sum
                }
            }
        }
        return res;
    }
}
