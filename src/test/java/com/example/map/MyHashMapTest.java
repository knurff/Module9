package com.example.map;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MyHashMapTest {

    private static final Map<Integer, String> MAP = new MyHashMap<>();

    @BeforeEach
    public void init() {
        assertNull(MAP.put(1, "abx"));
        assertNull(MAP.put(5, "qq"));
    }

    @AfterEach
    void teardown() {
        MAP.clear();
    }

    @Test
    void put() {
        assertNull(MAP.put(8, "123"));
        assertEquals("123", MAP.put(8, "12345"));
        assertEquals(3, MAP.size());
    }

    @Test
    void remove() {
        assertEquals("abx", MAP.remove(1));
        assertEquals(1, MAP.size());
    }

    @Test
    void clear() {
        assertEquals(2, MAP.size());
        MAP.clear();
        assertEquals(0, MAP.size());
    }

    @Test
    void size() {
        assertEquals(2, MAP.size());
    }

    @Test
    void get() {
        assertEquals("abx", MAP.get(1));
        assertEquals("qq", MAP.get(5));
    }
}