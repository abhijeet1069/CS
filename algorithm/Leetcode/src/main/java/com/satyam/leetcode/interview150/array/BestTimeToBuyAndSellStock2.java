package com.satyam.leetcode.interview150.array;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int[] diff = new int[prices.length-1];
        int profit = 0;
        for(int  i = 0; i < diff.length; i++)
            diff[i] = prices[i+1] - prices[i];

        for(int  i = 0; i < diff.length; i++)
            profit += Math.max(0,diff[i]); //add only positive values
        return profit;
    }
}
