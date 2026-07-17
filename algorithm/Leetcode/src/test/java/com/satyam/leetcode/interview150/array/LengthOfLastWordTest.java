package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {

    @ParameterizedTest
    @CsvSource({"Hello World,5",
            "   fly me   to   the moon  ,4",
            "luffy is still joyboy,6"
    })
    void testLength(String str, int expectedLen){
        assertEquals(expectedLen,new LengthOfLastWord().lengthOfLastWord(str));
    }
}