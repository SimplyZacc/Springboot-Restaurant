package com.example.restaurant.data.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Food {

    private int id;
    private int foodTypeId;
    private String foodName;
    private BigDecimal price;
    private String imageUrl;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public Food() {
        this.id = 0;
        this.foodName = "";
        this.price = BigDecimal.ZERO;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public Food(int id, String foodName, BigDecimal price) {
        this.id = id;
        this.foodName = foodName;
        this.price = price;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public Food(int id, String foodName, BigDecimal price, LocalDateTime dateCreated,
            LocalDateTime dateUpdated) {
        this.id = id;
        this.foodName = foodName;
        this.price = price;
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

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
        dateUpdated = LocalDateTime.now();
    }

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
        dateUpdated = LocalDateTime.now();
    }

    public String getFoodName() {
        return foodName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        dateUpdated = LocalDateTime.now();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        dateUpdated = LocalDateTime.now();
    }

    public String getImageUrl() {
        return imageUrl;
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
