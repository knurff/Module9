package com.example.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MyQueueTest {

    private static final Queue<Integer> QUEUE = new MyQueue<>();

    @BeforeEach
    public void init() {
        QUEUE.add(1);
        QUEUE.add(2);
        QUEUE.add(3);
        QUEUE.add(7);
        QUEUE.add(98);
    }

    @AfterEach
    void teardown() {
        QUEUE.clear();
    }

    @Test
    void add() {
        QUEUE.add(1);
        QUEUE.add(2);
        QUEUE.add(3);
        QUEUE.add(7);
        QUEUE.add(98);
        assertEquals(10, QUEUE.size());
    }

    @Test
    void remove() {
        assertEquals(3, QUEUE.remove(2));
        assertEquals(98, QUEUE.remove(3));
        assertEquals(3, QUEUE.size());
    }

    @Test
    void clear() {
        assertEquals(5, QUEUE.size());
        QUEUE.clear();
        assertEquals(0, QUEUE.size());
    }

    @Test
    void size() {
        assertEquals(5, QUEUE.size());
    }

    @Test
    void peek() {
        assertEquals(1, QUEUE.peek());
        assertEquals(1, QUEUE.peek());
    }

    @Test
    void poll() {
        assertEquals(1, QUEUE.poll());
        assertEquals(2, QUEUE.poll());
        assertEquals(3, QUEUE.poll());
        assertEquals(7, QUEUE.poll());
        assertEquals(98, QUEUE.poll());
        assertNull(QUEUE.poll());
    }
}