package com.satyam.leetcode.interview150.slidingWindow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstrWithoutRepeatTest {

    @ParameterizedTest
    @CsvSource({
            "3,abcabcbb",
            "1,bbbbb",
            "3,pwwkew"
    })
    void lengthOfLongestSubstring(int expected, String s) {
        assertEquals(expected, new LongestSubstrWithoutRepeat().lengthOfLongestSubstring(s));
    }
}