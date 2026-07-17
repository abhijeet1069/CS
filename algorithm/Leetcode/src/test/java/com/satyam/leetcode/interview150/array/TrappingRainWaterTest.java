package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    @ParameterizedTest
    @MethodSource("testData")
    void trap(int[] height, int expectedSum) {
        assertEquals(expectedSum,new TrappingRainWater().trap(height));
    }

    static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(
                        new int[]{4,2,0,3,2,5},
                        9
                ),
                Arguments.of(
                        new int[]{0,1,0,2,1,0,1,3,2,1,2,1},
                        6
                )
        );
    }
}