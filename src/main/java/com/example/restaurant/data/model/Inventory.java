package com.example.restaurant.data.model;

import java.time.LocalDateTime;

public class Inventory {
    private int foodId;
    private int supplierId;
    private int amount;
    private int minAmnt;
    private int maxAmnt;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public Inventory() {
        this.foodId = 0;
        this.supplierId = 0;
        this.amount = 0;
        this.minAmnt = 0;
        this.maxAmnt = 0;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public Inventory(int foodId, int supplierId, int amount, int minAmnt, int maxAmnt, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.foodId = foodId;
        this.supplierId = supplierId;
        this.amount = amount;
        this.minAmnt = minAmnt;
        this.maxAmnt = maxAmnt;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public int getFoodId() {
        return this.foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinAmnt() {
        return this.minAmnt;
    }

    public void setMinAmnt(int minAmnt) {
        this.minAmnt = minAmnt;
    }

    public int getMaxAmnt() {
        return this.maxAmnt;
    }

    public void setMaxAmnt(int maxAmnt) {
        this.maxAmnt = maxAmnt;
    }

    public LocalDateTime getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    
}
