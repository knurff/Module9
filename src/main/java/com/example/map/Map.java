package com.example.map;

public interface Map<K, V> {

    V put(K key, V value);

    V remove(K key);

    void clear();

    int size();

    V get(K key);
}
