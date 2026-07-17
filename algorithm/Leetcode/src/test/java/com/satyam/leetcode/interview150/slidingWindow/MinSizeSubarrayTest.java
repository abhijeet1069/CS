package com.satyam.leetcode.interview150.slidingWindow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinSizeSubarrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minSubArrayLen(int result, int target, int[] nums) {
        assertEquals(result, new MinSizeSubarray().minSubArrayLen(target,nums));
    }

    static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(2,7, new int[]{2,3,1,2,4,3}),
                Arguments.of(1,4, new int[]{1,4,4}),
                Arguments.of(0,11, new int[]{1,1,1,1,1,1,1,1})
        );
    }
}