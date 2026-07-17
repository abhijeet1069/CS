package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {

    @Test
    void should_return_count_of_unique_elements() {
        int[] nums = new int[]{1,1,2};
        Assertions.assertEquals(2, new RemoveDuplicates().removeDuplicates(nums));

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Assertions.assertEquals(5, new RemoveDuplicates().removeDuplicates(nums));
    }
}