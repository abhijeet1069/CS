package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CandyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void candy(int[] ratings, int expected) {
        assertEquals(expected,new Candy().candy(ratings));
    }

    static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(
                        new int[]{1,0,2},
                        5
                ),
                Arguments.of(
                        new int[]{1,2,2},
                        4
                )
        );
    }

}