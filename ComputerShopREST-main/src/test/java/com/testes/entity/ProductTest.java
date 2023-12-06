package com.testes.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testGetId() {
        Product product = new Product();
        product.setId(1L);
        assertEquals(1L, product.getId());
    }

    @Test
    public void testSetId() {
        Product product = new Product();
        product.setId(2L);
        assertEquals(2L, product.getId());
    }

    @Test
    public void testGetSerialNumber() {
        Product product = new Product("SN123", "Manufacturer", 99.99, 5);
        assertEquals("SN123", product.getSerialNumber());
    }

    @Test
    public void testSetSerialNumber() {
        Product product = new Product();
        product.setSerialNumber("SN456");
        assertEquals("SN456", product.getSerialNumber());
    }

    @Test
    public void testGetManufacturer() {
        Product product = new Product("SN789", "AnotherManufacturer", 149.99, 3);
        assertEquals("AnotherManufacturer", product.getManufacturer());
    }

    @Test
    public void testSetManufacturer() {
        Product product = new Product();
        product.setManufacturer("NewManufacturer");
        assertEquals("NewManufacturer", product.getManufacturer());
    }

    @Test
    public void testGetPrice() {
        Product product = new Product("SN101", "YetAnotherManufacturer", 199.99, 2);
        assertEquals(199.99, product.getPrice(), 0.001); // Utilize delta para lidar com imprecisões de ponto flutuante
    }

    @Test
    public void testSetPrice() {
        Product product = new Product();
        product.setPrice(299.99);
        assertEquals(299.99, product.getPrice(), 0.001);
    }

    @Test
    public void testGetQuantity() {
        Product product = new Product("SN202", "LastManufacturer", 399.99, 1);
        assertEquals(1, product.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        Product product = new Product();
        product.setQuantity(3);
        assertEquals(3, product.getQuantity());
    }
}
