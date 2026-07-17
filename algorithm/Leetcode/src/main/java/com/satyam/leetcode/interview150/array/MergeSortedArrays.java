package com.satyam.leetcode.interview150.array;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int index = 0, i = 0, j = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                res[index] = nums1[i];
                i++;
            }
            else{
                res[index] = nums2[j];
                j++;
            }
            index++;
        }

        while (i < m){
            res[index] = nums1[i];
            i++;
            index++;
        }

        while (j < n){
            res[index] = nums2[j];
            j++;
            index++;
        }
        for(int k = 0;k < m+n; k++)
            nums1[k] = res[k];
    }
}
