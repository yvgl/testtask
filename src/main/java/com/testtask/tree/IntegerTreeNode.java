package com.testtask.tree;

import java.util.Collection;

public class IntegerTreeNode extends TreeNode<Integer> {

    IntegerTreeNode(Integer value, Collection<TreeNode<Integer>> children) {
        super(value, children);
    }

    @Override
    Integer add(Integer first, Integer second) {
        return first + second;
    }
}