package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayTest {

    @Test
    void productExceptSelf() {
        int[] arr = {1,2,3,4};
        int[] expected = {24,12,8,6};
        assertArrayEquals(expected,new ProductOfArray().productExceptSelf(arr));
    }
}