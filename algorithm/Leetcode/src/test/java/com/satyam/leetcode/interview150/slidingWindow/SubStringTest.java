package com.satyam.leetcode.interview150.slidingWindow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SubStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findSubstring(String s, String[] words, List<Integer> expected) {
        assertEquals(expected, new SubString().findSubstring(s,words));
    }

    static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(
                        "barfoothefoobarman",
                        new String[]{"foo","bar"},
                        List.of(0,9)
                )
        );
    }

    @Test
     void quadloop() {
        int[] arr = new int[]{1,2,3,4};
        int ctr = 0;
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j)
                        continue;

                    for (int l = 0; l < 4; l++) {
                        if (l == i || l == j || l == k)
                            continue;
                        ctr++;
                        System.out.println("ctr = "+ctr+" i = "+i+" j = "+j+" k = "+k);
                    }
                }
            }
        }
    }
}