package com.example.restaurant.data.model;

import java.time.LocalDateTime;

public class OrderItem {
    private int foodId;
    private int orderId;
    private short amount;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


    public OrderItem() {
        this.foodId = 0;
        this.orderId = 0;
        this.amount = 0;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }


    public OrderItem(int foodId, int orderId, short amount, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.foodId = foodId;
        this.orderId = orderId;
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public int getFoodId() {
        return this.foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public short getAmount() {
        return this.amount;
    }

    public void setAmount(short amount) {
        this.amount = amount;
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
