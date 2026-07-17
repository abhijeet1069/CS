package com.satyam.leetcode.interview150.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JumpGameTest {

    @Test
    void canJump1() {
        int[] nums = {2,3,1,1,4};
        Assertions.assertTrue(new JumpGame().canJump(nums));
    }

    @Test
    void canJump2() {
        int[] nums = {3,2,1,0,4};
        Assertions.assertFalse(new JumpGame().canJump(nums));
    }

    @Test
    void canJump3() {
        int[] nums = {2,0,0};
        Assertions.assertTrue(new JumpGame().canJump(nums));
    }

    @Test
    void canJump4() {
        int[] nums = {0};
        Assertions.assertTrue(new JumpGame().canJump(nums));
    }

    @Test
    void canJump5() {
        int[] nums = {0,2,3};
        Assertions.assertFalse(new JumpGame().canJump(nums));
    }
}