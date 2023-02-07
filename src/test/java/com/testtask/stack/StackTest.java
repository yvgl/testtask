package com.testtask.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void elementsPushedAndPopped() {
        Stack<String> stack = new Stack<>(3);
        Assertions.assertTrue(stack.isEmpty());

        stack.push("first");
        Assertions.assertEquals(1, stack.size());
        Assertions.assertFalse(stack.isEmpty());

        stack.push("second");
        Assertions.assertEquals(2, stack.size());
        Assertions.assertFalse(stack.isFull());

        stack.push("third");
        Assertions.assertTrue(stack.isFull());
        Assertions.assertEquals(3, stack.size());

        Assertions.assertEquals("third", stack.peek());
        Assertions.assertEquals("third", stack.pop());
        Assertions.assertEquals(2, stack.size());

        Assertions.assertEquals("second", stack.pop());
        Assertions.assertEquals(1, stack.size());

        Assertions.assertEquals("first", stack.pop());
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void exceptionThrown_whenPopOnEmptyStackCalled() {
        Assertions.assertThrows(Stack.EmptyStackException.class, () -> new Stack<>(10).pop());
    }

    @Test
    void exceptionThrown_whenPeekOnEmptyStackCalled() {
        Assertions.assertThrows(Stack.EmptyStackException.class, () -> new Stack<>(10).peek());
    }

    @Test
    void exceptionThrown_whenPushOnFullStackCalled() {
        Assertions.assertThrows(Stack.FullStackException.class, () -> {
            Stack<Integer> stack = new Stack<>(1);
            stack.push(10);
            stack.push(11);
        });
    }

    @Test
    void capacityGrown() {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(1);
        Assertions.assertTrue(stack.isFull());

        stack.grow(2);

        Assertions.assertFalse(stack.isFull());
        stack.push(2);
        stack.push(3);
        Assertions.assertTrue(stack.isFull());
    }
}