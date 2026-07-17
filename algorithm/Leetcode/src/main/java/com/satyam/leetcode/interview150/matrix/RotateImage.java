package com.satyam.leetcode.interview150.matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        //transpose entire matrix
        for(int i = 0; i < row; i++){
            for(int j = i+1; j < col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //interchange colums with center column as mirror
        int l = 0, r = col-1;
        while(l < r){
            for(int i = 0; i < col ;i++){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            l++;
            r--;
        }
    }
}
