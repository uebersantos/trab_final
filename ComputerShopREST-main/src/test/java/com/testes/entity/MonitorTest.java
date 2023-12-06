package com.testes.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonitorTest {

    @Test
    public void testGetDiagonal() {
        Monitor monitor = new Monitor("12345", "Manufacturer", 199.99, 5, 24.5);
        assertEquals(24.5, monitor.getDiagonal(), 0.001); // Utilize delta para lidar com imprecisões de ponto flutuante
    }

    @Test
    public void testSetDiagonal() {
        Monitor monitor = new Monitor();
        monitor.setDiagonal(27.0);
        assertEquals(27.0, monitor.getDiagonal(), 0.001);
    }

    @Test
    public void testConstructorWithDiagonal() {
        Monitor monitor = new Monitor("67890", "AnotherManufacturer", 299.99, 3, 21.5);
        assertEquals(21.5, monitor.getDiagonal(), 0.001);
    }

    @Test
    public void testDefaultConstructor() {
        Monitor monitor = new Monitor();
        assertEquals(0.0, monitor.getDiagonal(), 0.001);
    }
}
