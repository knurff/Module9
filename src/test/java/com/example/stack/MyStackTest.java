package com.example.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MyStackTest {

    private static final Stack<Integer> STACK = new MyStack<>();

    @BeforeEach
    public void init() {
        STACK.push(1);
        STACK.push(2);
        STACK.push(3);
        STACK.push(7);
        STACK.push(98);
    }

    @AfterEach
    void teardown() {
        STACK.clear();
    }

    @Test
    void push() {
        STACK.push(1);
        STACK.push(2);
        STACK.push(3);
        STACK.push(7);
        STACK.push(98);
        assertEquals(10, STACK.size());
    }

    @Test
    void remove() {
        assertEquals(3, STACK.remove(2));
        assertEquals(98, STACK.remove(3));
        assertEquals(3, STACK.size());
    }

    @Test
    void clear() {
        assertEquals(5, STACK.size());
        STACK.clear();
        assertEquals(0, STACK.size());
    }

    @Test
    void size() {
        assertEquals(5, STACK.size());
    }

    @Test
    void peek() {
        assertEquals(98, STACK.peek());
        assertEquals(98, STACK.peek());
    }

    @Test
    void pop() {
        assertEquals(98, STACK.pop());
        assertEquals(7, STACK.pop());
        assertEquals(3, STACK.pop());
        assertEquals(2, STACK.pop());
        assertEquals(1, STACK.pop());
        assertNull(STACK.pop());
    }
}