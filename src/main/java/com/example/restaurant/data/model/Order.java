package com.example.restaurant.data.model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private OrderStatus status;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public Order() {
        this.id = 0;
        this.status = OrderStatus.CANCELED;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public Order(int id, OrderStatus status) {
        this.id = id;
        this.status = status;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public Order(int id, OrderStatus status, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.id = id;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public void setId(int id) {
        this.id = id;
        dateUpdated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        dateUpdated = LocalDateTime.now();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        dateUpdated = LocalDateTime.now();
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }
}
