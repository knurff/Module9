package com.example.stack;

import java.util.Arrays;
import java.util.Objects;

public class MyStack<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    public MyStack(int initCapacity) {
        if (initCapacity <= 0)
            throw new IllegalArgumentException();

        elementData = new Object[initCapacity];
    }

    @Override
    public void push(T element) {
        increaseDataArrayIfFull();
        elementData[size] = element;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        Objects.checkIndex(index, size);
        var deletedElement = (T) elementData[index];

        if (index < size - 1)
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);

        elementData[size - 1] = null;
        size--;

        return deletedElement;
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size > 0)
            return (T) elementData[size - 1];
        else return null;
    }

    @Override
    public T pop() {
        if (size == 0) return null;
        return remove(size - 1);
    }

    private void increaseDataArrayIfFull() {
        if (elementData.length == size)
            elementData = Arrays.copyOf(elementData, size * 2);
    }
}
