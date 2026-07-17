package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MajorityElementTest {

    @Test
    void majorityElement() {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        Assertions.assertEquals(2,new MajorityElement().majorityElement(nums));
    }
}