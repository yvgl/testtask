package com.testtask.tree;

import java.util.ArrayList;
import java.util.Collection;

public abstract class TreeNode<T> {

    final T value;
    final Collection<TreeNode<T>> children;

    TreeNode(T value, Collection<TreeNode<T>> children) {
        this.value = value;
        this.children = children;
    }

    public T sum() {
        if (null == children || children.isEmpty()) {
            return value;
        }

        Collection<T> allNodes = new ArrayList<>();
        visit(this, allNodes);

        return allNodes.stream().reduce(this::add).orElse(null);
    }

    private void visit(TreeNode<T> node, Collection<T> allNodes) {
        if (null == node) {
            return;
        }

        allNodes.add(node.value);

        if (null == node.children) {
            return;
        }

        for (TreeNode<T> child : node.children) {
            visit(child, allNodes);
        }
    }

    abstract T add(T first, T second);
}
