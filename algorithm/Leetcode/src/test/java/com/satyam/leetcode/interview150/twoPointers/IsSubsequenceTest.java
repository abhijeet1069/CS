package com.satyam.leetcode.interview150.twoPointers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class IsSubsequenceTest {

    @ParameterizedTest
    @CsvSource({
            "abc,ahbgdc,true",
            "axc,ahbgdc,false",
    })
    void isSubsequence(String s, String t, boolean expectedResult) {
        assertEquals(expectedResult, new IsSubsequence().isSubsequence(s,t));
    }
}