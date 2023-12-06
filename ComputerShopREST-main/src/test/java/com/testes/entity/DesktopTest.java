package com.testes.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DesktopTest {

    @Test
    public void testGetFormFactor() {
        Desktop desktop = new Desktop("12345", "Manufacturer", 999.99, 5, "ATX");
        assertEquals("ATX", desktop.getFormFactor());
    }

    @Test
    public void testSetFormFactor() {
        Desktop desktop = new Desktop();
        desktop.setFormFactor("MicroATX");
        assertEquals("MicroATX", desktop.getFormFactor());
    }

    @Test
    public void testConstructorWithFormFactor() {
        Desktop desktop = new Desktop("12345", "Manufacturer", 999.99, 5, "MiniITX");
        assertEquals("MiniITX", desktop.getFormFactor());
    }

    @Test
    public void testDefaultConstructor() {
        Desktop desktop = new Desktop();
        assertNull(desktop.getFormFactor());
    }

}
