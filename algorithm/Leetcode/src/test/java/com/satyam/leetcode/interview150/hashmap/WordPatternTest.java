package com.satyam.leetcode.interview150.hashmap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordPatternTest {

    @Test
    void splitTest(){
        String[] expected = new String[]{"dog","cat","cat","dog"};
        String s = "dog cat cat dog";
        assertArrayEquals(expected, s.split("\\s+"));
    }

    @ParameterizedTest
    @MethodSource("stringListData")
    void wordPattern(boolean expected, String pattern, String s) {
        assertEquals(expected, new WordPattern().wordPattern(pattern,s));
    }

    static Stream<Arguments> stringListData(){
        return Stream.of(
                Arguments.of(
                        true,
                        "abba",
                        "dog cat cat dog"
                ),
                Arguments.of(
                        false,
                        "aaaa",
                        "dog cat cat dog"
                ),
                Arguments.of(
                        false,
                        "abba",
                        "dog dog dog dog"
                )
        );
    }

}