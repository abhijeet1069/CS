package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HIndexTest {

    @Test
    void hIndex() {
        int[] citations = {3,0,6,1,5};
        assertEquals(3, new HIndex().hIndex(citations));
    }
}