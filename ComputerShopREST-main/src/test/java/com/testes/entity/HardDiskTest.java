package com.testes.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HardDiskTest {

    @Test
    public void testGetCapacity() {
        HardDisk hardDisk = new HardDisk("12345", "Manufacturer", 99.99, 3, 500);
        assertEquals(500, hardDisk.getCapacity());
    }

    @Test
    public void testSetCapacity() {
        HardDisk hardDisk = new HardDisk();
        hardDisk.setCapacity(1000);
        assertEquals(1000, hardDisk.getCapacity());
    }

    @Test
    public void testConstructorWithCapacity() {
        HardDisk hardDisk = new HardDisk("67890", "AnotherManufacturer", 149.99, 2, 1000);
        assertEquals(1000, hardDisk.getCapacity());
    }

    @Test
    public void testDefaultConstructor() {
        HardDisk hardDisk = new HardDisk();
        assertEquals(0, hardDisk.getCapacity());
    }

}
