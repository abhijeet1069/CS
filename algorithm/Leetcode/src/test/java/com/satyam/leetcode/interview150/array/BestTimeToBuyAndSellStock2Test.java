package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellStock2Test {

    @Test
    void maxProfit() {
        int[] arr = {7,1,5,3,6,4};
        Assertions.assertEquals(7,new BestTimeToBuyAndSellStock2().maxProfit(arr));
    }
}