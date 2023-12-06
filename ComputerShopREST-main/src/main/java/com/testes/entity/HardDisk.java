package com.testes.entity;

import jakarta.persistence.Entity;

@Entity
public class HardDisk extends Product {

    private int capacity;

    public HardDisk() {
    }

    public HardDisk(int capacity) {
        this.capacity = capacity;
    }

    public HardDisk(String serialNumber, String manufacturer, double price, int quantity, int capacity) {
        super(serialNumber, manufacturer, price, quantity);
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
