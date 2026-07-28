package com.satyam.algo.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void testInsert() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(8);
        bst.insert(12);
        bst.insert(20);

        assertEquals("3 5 8 10 12 15 20", bst.inorder());
        assertEquals("10 5 3 8 15 12 20", bst.preorder());

        assertTrue(bst.search(8));
        assertFalse(bst.search(30));

        assertEquals(2,bst.height());
        assertEquals(7,bst.countNodes());
        assertEquals(4,bst.countLeaves());
    }
}