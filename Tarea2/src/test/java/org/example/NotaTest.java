package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class NotaTest {
    private Nota content;
    @BeforeEach
    void setUp() {
        content = new Nota("Suban los sueldos");
    }

    @AfterEach
    void tearDown() {
        content=null;
    }

    @Test
    void testToString() {
        assertEquals("Suban los sueldos", content.toString());
    }
}