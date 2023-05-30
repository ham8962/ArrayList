package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListTest {
    private ArrayList<String> list;

    @BeforeEach
    void setup() {
        list = new ArrayList<>(3);
    }

    @Test
    void testAddLast() {
        list.addLast("apple");
        list.addLast("banana");
        list.addLast("orange");

        assertEquals(list.size(), 3);
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
        assertEquals("orange", list.get(2));
    }

    @Test
    void testAdd() {
        list.addLast("apple");
        list.addLast("banana");
        list.addLast("orange");

        list.add(3, "mango");
        list.add(1, "grape");

        assertEquals(5, list.size());
        assertEquals("apple", list.get(0));
        assertEquals("grape", list.get(1));
        assertEquals("banana", list.get(2));
        assertEquals("orange", list.get(3));
        assertEquals("mango", list.get(4));
    }

    @Test
    void testRemove() {
        list.addLast("apple");
        list.addLast("banana");
        list.addLast("orange");

        boolean removed = list.remove("banana");

        assertTrue(removed);
        assertEquals(2, list.size());
        assertEquals("apple", list.get(0));
        assertEquals("orange", list.get(1));
    }

    @Test
    void testSet() {
        list.addLast("apple");
        list.addLast("banana");
        list.addLast("orange");

        list.set(2,"Grape");

        assertEquals("Grape", list.get(2));
    }

    @Test
    void testContain(){
        list.addLast("apple");
        list.addLast("banana");
        list.addLast("orange");

        assertTrue(list.contain("apple"));
        assertFalse(list.contain("lemon"));
    }


    @Test
    void testClear() {
        list.addLast("apple");
        list.addLast("banana");
        list.addLast("orange");

        list.clear();

        assertEquals(0, list.size());
    }

}