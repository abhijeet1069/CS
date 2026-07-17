package com.algorithms.fundamentals.basicpm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MathProcessingTest {

    @ParameterizedTest
    @CsvSource({
            "2, -2",
            "2, 2"
    })
    void abs(int expected, int num) {
        assertEquals(expected,MathProcessing.abs(num));
    }

    @ParameterizedTest
    @CsvSource({
            "false, 4",
            "false, 8",
            "true, 13",
            "false, 42"
    })
    void isPrime(boolean expected, int num) {
        assertEquals(expected,MathProcessing.isPrime(num));
    }

    @ParameterizedTest
    @CsvSource({
            "2.0, 4.0",
            "10, 100",
            "1.4142, 2",
            "4, 16"
    })
    void sqrt(double expected, double num) {
        assertEquals(expected,MathProcessing.sqrt(num),0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "2.928, 10",
            "5.187, 100",
            "14.393, 1000000",
            "18.998, 100000000"
    })
    void harmonic(double expected, int num) {
        assertEquals(expected,MathProcessing.harmonic(num),0.01);
    }
}