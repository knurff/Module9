package com.example.list;

public interface List<T> {

    void add(T element);

    T remove(int index);

    void clear();

    int size();

    T get(int index);
}
