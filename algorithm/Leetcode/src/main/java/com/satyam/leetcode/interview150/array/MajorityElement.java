package com.satyam.leetcode.interview150.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        int threshold = nums.length/2;
        for(int key : map.keySet()){
            if(map.get(key) > threshold)
                return key;
        }
        return -1;
    }
}
