package com.satyam.leetcode.interview150.twoPointers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @ParameterizedTest
    @MethodSource("stringData")
    void isPalindrome(String input, boolean expected) {
        assertEquals(expected,new ValidPalindrome().isPalindrome(input));
    }

    static Stream<Arguments> stringData(){
        return Stream.of(
          Arguments.of("A man, a plan, a canal: Panama",true),
          Arguments.of("race a car",false),
          Arguments.of(" ",true)
        );
    }
}