package com.example.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLinkedListTest {

    private static final List<Integer> LIST = new MyLinkedList<>();

    @BeforeEach
    public void init() {
        LIST.add(1);
        LIST.add(2);
        LIST.add(3);
        LIST.add(1000);
        LIST.add(72);
    }

    @AfterEach
    void teardown() {
        LIST.clear();
    }

    @Test
    void add() {
        LIST.add(1);
        LIST.add(2);
        LIST.add(3);
        LIST.add(1000);
        LIST.add(72);
        assertEquals(10, LIST.size());
    }

    @Test
    void remove() {
        assertEquals(1, LIST.remove(0));
        assertEquals(72, LIST.remove(3));
        assertEquals(3, LIST.size());
    }

    @Test
    void clear() {
        assertEquals(5, LIST.size());
        LIST.clear();
        assertEquals(0, LIST.size());
    }

    @Test
    void size() {
        assertEquals(5, LIST.size());
    }

    @Test
    void get() {
        assertEquals(1, LIST.get(0));
        assertEquals(2, LIST.get(1));
        assertEquals(3, LIST.get(2));
        assertEquals(1000, LIST.get(3));
        assertEquals(72, LIST.get(4));
    }
}