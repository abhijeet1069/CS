package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {

    @ParameterizedTest
    @CsvSource({"30,XXX",
                "4,IV",
                "90,XC",
                "400,CD",
                "50,L",
                "500,D",
                "2,II"
    })
    void intToRoman(int num, String expectedRoman) {
        assertEquals(expectedRoman,new IntegerToRoman().intToRoman(num));
    }
}