package com.satyam.leetcode.interview150.twoPointers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void threeSum(int[] nums, List<List<Integer>> expected) {
        assertEquals(expected, new ThreeSum().threeSum(nums));
    }

    static Stream<Arguments> testCases(){
        return Stream.of(
                Arguments.of(
                        new int[]{-1,0,1,2,-1,-4},
                        List.of(
                            List.of(-1,-1,2),
                            List.of(-1,0,1)
                    )
                ),
                Arguments.of(
                        new int[]{0,1,1},
                        List.of()
                ),
                Arguments.of(
                        new int[]{0,0,0},
                        List.of(
                                List.of(0,0,0)
                        )
                ),
                Arguments.of(
                        new int[]{-100,-70,-60,110,120,130,160},
                        List.of(
                                List.of(-100,-60,160),
                                List.of(-70,-60,130)
                        )
                )
        );
    }
}