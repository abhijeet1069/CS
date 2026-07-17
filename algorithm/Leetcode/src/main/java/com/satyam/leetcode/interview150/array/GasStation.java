package com.satyam.leetcode.interview150.array;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0;
        int total_surplus = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            surplus += gas[i]-cost[i];
            total_surplus += gas[i]-cost[i];
            if(surplus < 0){
                surplus = 0;
                index = i+1;
            }
        }
        return total_surplus >= 0 ? index:-1;
    }
}
