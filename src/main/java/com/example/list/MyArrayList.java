package com.example.list;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initCapacity) {
        if (initCapacity <= 0)
            throw new IllegalArgumentException();

        elementData = new Object[initCapacity];
    }

    @Override
    public void add(T element) {
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
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    private void increaseDataArrayIfFull() {
        if (elementData.length == size)
            elementData = Arrays.copyOf(elementData, size * 2);
    }
}
