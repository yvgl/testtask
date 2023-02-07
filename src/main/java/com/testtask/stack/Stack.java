package com.testtask.stack;

public class Stack<T> {

    private int capacity;
    private int size = 0;
    private Node<T> last;

    public Stack(int capacity) {
        checkBiggerThanZero(capacity);
        this.capacity = capacity;
    }

    private void checkBiggerThanZero(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity should be greater than 0");
        }
    }

    public synchronized void push(T value) {
        if (isFull()) {
            throw new FullStackException();
        }

        last = new Node<>(value, last);
        size++;
   }

   public synchronized T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T value = last.value;
        last = last.prev;
        size--;

        return value;
   }

   public synchronized T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return last.value;
   }

   public synchronized void grow(int capacity) {
        checkBiggerThanZero(capacity);
        this.capacity += capacity;
   }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }


    public static class EmptyStackException extends RuntimeException {
    }


    public static class FullStackException extends RuntimeException {
    }


    private record Node<T>(T value, Stack.Node<T> prev) {
    }

}
