package com.example.restaurant.data.dto;

import java.math.BigDecimal;

public class FoodDto {
    
    public int foodTypeId;
    public String foodName;
    public BigDecimal price;
    public String imageUrl;

    public FoodDto(int foodTypeId, String foodName, BigDecimal price, String imageUrl) {
        this.foodName = foodName;
        this.foodTypeId = foodTypeId;
        this.price = price;
        this.imageUrl = imageUrl;
    }   

}
