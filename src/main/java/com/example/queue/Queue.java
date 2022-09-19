package com.example.queue;

public interface Queue<T> {

    void add(T element);

    T remove(int index);

    void clear();

    int size();

    T peek();

    T poll();
}
