package com.satyam.leetcode.interview150.array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minCost = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            profit = Math.max(profit,prices[i]-minCost);
            minCost = Math.min(minCost,prices[i]);
        }
        return profit;
    }
}