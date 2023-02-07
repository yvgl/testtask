package com.testtask.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class IntegerTreeNodeTest {

    @Test
    void sumCalculated() {
        IntegerTreeNode nodeWithChildren = new IntegerTreeNode(
                3000, List.of(new IntegerTreeNode(
                400, List.of(new IntegerTreeNode(50, null))))
        );

        List<TreeNode<Integer>> children = List.of(
                new IntegerTreeNode(20000, null),
                nodeWithChildren,
                new IntegerTreeNode(6, null));

        TreeNode<Integer> head = new IntegerTreeNode(100000, children);

        Assertions.assertEquals(123456, head.sum());
    }

}