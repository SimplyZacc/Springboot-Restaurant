package com.example.restaurant.data.model;

import java.time.LocalDateTime;

public class FoodType {

    private int foodTypeId;
    private String foodTypeName;
    private boolean isActive;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public FoodType() {
        this.foodTypeId = 0;
        this.foodTypeName = "";
        this.isActive = false;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public FoodType(
            int foodTypeId,
            String foodTypeName,
            boolean isActive) {
        this.foodTypeId = foodTypeId;
        this.foodTypeName = foodTypeName;
        this.isActive = isActive;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public FoodType(
            int foodTypeId,
            String foodTypeName,
            boolean isActive,
            LocalDateTime dateCreated,
            LocalDateTime dateUpdated
            ) {
        this.foodTypeId = foodTypeId;
        this.foodTypeName = foodTypeName;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
        dateUpdated = LocalDateTime.now();
    }

    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
        dateUpdated = LocalDateTime.now();
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
        dateUpdated = LocalDateTime.now();
    }

    public boolean getActive() {
        return isActive;
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
