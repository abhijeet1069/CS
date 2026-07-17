package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellStockTest {

    @Test
    void maxProfit1() {
        int[] arr = {7,1,5,3,6,4};
        Assertions.assertEquals(5,new BestTimeToBuyAndSellStock().maxProfit(arr));
    }

    @Test
    void maxProfit2() {
        int[] arr = {7,6,4,3,1};
        Assertions.assertEquals(0,new BestTimeToBuyAndSellStock().maxProfit(arr));
    }
}