package com.satyam.leetcode.interview150.array;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {

    @ParameterizedTest
    @MethodSource("gasStationTestData")
    void testGas1(int[] gas, int[] cost, int expected){
        assertEquals(expected,new GasStation().canCompleteCircuit(gas,cost));

    }

    static Stream<Arguments> gasStationTestData(){
        return Stream.of(
                Arguments.of(
                        new int[]{1,2,3,4,5},
                        new int[]{3,4,5,1,2},
                        3
                ),
                Arguments.of(
                        new int[]{2,3,4},
                        new int[]{3,4,3},
                        -1
                )
        );
    }

}