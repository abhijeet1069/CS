package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("stringListData")
    void longestCommonPrefix(String[] strs, String expectedCommonPrefix) {
        assertEquals(expectedCommonPrefix, new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    static Stream<Arguments> stringListData(){
        return Stream.of(
                Arguments.of(
                        new String[]{"flower","flow","flight"},
                        "fl"
                ),
                Arguments.of(
                        new String[]{"dog","racecar","car"},
                        ""
                ),
                Arguments.of(
                        new String[]{"cir","car"},
                        "c"
                )
        );
    }
}