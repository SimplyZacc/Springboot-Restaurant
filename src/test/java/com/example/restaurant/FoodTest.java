package com.example.restaurant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restaurant.data.model.Food;
import com.example.restaurant.service.FoodService;

@SpringBootTest
public class FoodTest {
    
    @Autowired
    private FoodService foodService;

    @Test
    @DisplayName("Get all foods service test ")
    void testGetAllFoods(){
        List<Food> foods = foodService.getAllFoods();
        assertFalse(foods.isEmpty());
    }

    @Test
    @DisplayName("Get top 2 foods test ")
    void getTwoFoods(){
        List<Food> foods = foodService.getAmountOfFood(2);
        assertTrue(foods.size()==2);
        assertFalse(foods.size()>2);
        assertFalse(foods.size()<2);
    }
}
