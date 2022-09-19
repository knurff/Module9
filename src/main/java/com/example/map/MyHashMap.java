package com.example.map;

import static java.util.Objects.requireNonNull;

public class MyHashMap<K, V> implements Map<K, V> {

    private static final class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float RESIZE_THRESHOLD = 1.0f;
    private Node<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity) {
        verifyCapacity(initialCapacity);
        this.table = new Node[initialCapacity];
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public V put(K key, V value) {
        resizeIfNeeded();
        return putOnTable(table, key, value);
    }

    private void resizeIfNeeded() {
        if (size / (float) table.length > RESIZE_THRESHOLD) resizeTable(2 * table.length);
    }

    private V putOnTable(Node<K, V>[] table, K key, V value) {
        var newNode = new Node<>(requireNonNull(key), requireNonNull(value));
        var index = calculateIndex(key);

        if (table[index] == null) table[index] = newNode;
        else {
            var current = table[index];

            while (current.next != null) {
                if (current.key.equals(key)) {
                    var prevValue = current.value;
                    current.value = value;
                    return prevValue;
                }
                current = current.next;
            }

            if (current.key.equals(key)) {
                var prevValue = current.value;
                current.value = value;
                return prevValue;
            }

            current.next = newNode;
        }

        size++;
        return null;
    }

    @Override
    public V remove(K key) {
        var index = calculateIndex(requireNonNull(key));
        var current = table[index];

        if (current != null) {
            if (current.key.equals(key)) {
                var value = current.value;
                table[index] = current.next;
                size--;
                return value;
            }

            while (current.next != null) {
                if (current.next.key.equals(key)) {
                    var value = current.next.value;
                    current.next = current.next.next;
                    size--;
                    return value;
                }

                current = current.next;
            }
        }

        return null;
    }


    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        var index = calculateIndex(requireNonNull(key));
        var current = table[index];

        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }

        return null;
    }

    private void resizeTable(int newCapacity) {
        verifyCapacity(newCapacity);
        @SuppressWarnings("unchecked") Node<K, V>[] newTable = new Node[newCapacity];

        for (var head : table) {
            var current = head;

            while (current != null) {
                putOnTable(newTable, current.key, current.value);
                current = current.next;
            }

        }

        table = newTable;
    }

    private void verifyCapacity(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
    }

    private int calculateIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % table.length;
    }
}
