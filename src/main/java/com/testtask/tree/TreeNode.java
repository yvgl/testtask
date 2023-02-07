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

        Collection<T> values = new ArrayList<>();
        visit(this, values);

        return values.stream().reduce(this::add).orElse(null);
    }

    private void visit(TreeNode<T> node, Collection<T> values) {
        if (null == node) {
            return;
        }

        values.add(node.value);

        if (null == node.children) {
            return;
        }

        for (TreeNode<T> child : node.children) {
            visit(child, values);
        }
    }

    abstract T add(T first, T second);
}
