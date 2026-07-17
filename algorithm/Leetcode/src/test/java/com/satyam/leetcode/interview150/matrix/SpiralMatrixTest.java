package com.satyam.leetcode.interview150.matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixTest {

    @Test
    void spiralOrder() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = Arrays.asList(1,2,3,6,9,8,7,4,5);
        assertEquals(res,new SpiralMatrix().spiralOrder(matrix));
    }
}