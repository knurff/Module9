package com.example.stack;

public interface Stack<T> {

    void push(T element);

    T remove(int index);

    void clear();

    int size();

    T peek();

    T pop();
}
