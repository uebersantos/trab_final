package com.testes.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaptopTest {
    @Test
    public void testGetScreenSize() {
        Laptop laptop = new Laptop("12345", "Manufacturer", 999.99, 3, 15);
        assertEquals(15, laptop.getScreenSize());
    }

    @Test
    public void testSetScreenSize() {
        Laptop laptop = new Laptop();
        laptop.setScreenSize(13);
        assertEquals(13, laptop.getScreenSize());
    }

    @Test
    public void testConstructorWithScreenSize() {
        Laptop laptop = new Laptop("67890", "AnotherManufacturer", 1499.99, 2, 17);
        assertEquals(17, laptop.getScreenSize());
    }

    @Test
    public void testDefaultConstructor() {
        Laptop laptop = new Laptop();
        assertEquals(0, laptop.getScreenSize());
    }

}
