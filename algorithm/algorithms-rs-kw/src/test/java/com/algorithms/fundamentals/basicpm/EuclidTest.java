package com.algorithms.fundamentals.basicpm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EuclidTest {

    @ParameterizedTest
    @CsvSource({
            "2,4,2",
            "10,5,5",
    })
    void gcd(int a, int b, int expected) {
        assertEquals(expected,Euclid.gcd(a,b));
    }
}