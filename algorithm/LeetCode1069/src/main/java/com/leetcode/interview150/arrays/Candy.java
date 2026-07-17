package com.satyam.leetcode.interview150.array;

public class Candy {
    public int candy(int[] ratings) {
        int[] l = new int[ratings.length];
        int[] r = new int[ratings.length];

        l[0] = 1;
        for(int i = 1;i < ratings.length; i++){
            //If a child has higher ratings than his left neighbor, give him one more candy
            if(ratings[i] > ratings[i-1])
                l[i] = ratings[i]+1;
            else
                l[i] = 1;
        }

        r[ratings.length-1] = 1;
        for(int i = ratings.length-2; i >= 0; i--){
            //If a child has higher ratings than his right neighbor, give him one more candy
            if (ratings[i] > ratings[i+1])
                r[i] = ratings[i]+1;
            else
                r[i] = 1;
        }

        int totalCandy = 0;
        for(int i = 1; i < ratings.length; i++){
            totalCandy += Math.max(l[i],r[i]);
        }
    return totalCandy;
    }
}
