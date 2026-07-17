package com.satyam.leetcode.contest.virtual1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountValidOccurenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countWordOccurrences(int[] expected, String[] chunks, String[] queries) {
        assertArrayEquals(expected, new CountValidOccurence().countWordOccurrences(chunks,queries));
    }

    static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(new int[]{2,1,0}
                        ,new String[]{"hello wor","ld hello"},
                        new String[]{"hello","world","wor"}),
                Arguments.of(new int[]{2,1,1}
                        ,new String[]{"a--b a-","-c"},
                        new String[]{"a","b","c"})
        );
    }
}