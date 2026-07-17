package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RemoveElementTest {

    @Test
    void output_should_be_element_count_which_are_not_equal_to_val() {
        int[] num = {3,2,2,3};
        int val = 3;
        Assertions.assertEquals(2, new RemoveElement().removeElement(num,val));
    }
}