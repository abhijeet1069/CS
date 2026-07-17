package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ZigzagConversionTest {

    @ParameterizedTest
    @CsvSource({
            "PAYPALISHIRING, 3, PAHNAPLSIIGYIR",
            "PAYPALISHIRING, 4, PINALSIGYAHRPI",
            "AB, 1, AB"

    })
    void convert(String s, int numRows, String expectedPattern) {
        assertEquals(expectedPattern, new ZigzagConversion().convert(s,numRows));
    }
}