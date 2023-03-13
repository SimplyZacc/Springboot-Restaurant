package com.example.restaurant.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restaurant.data.model.Food;
import com.example.restaurant.repository.FoodRepository;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFood() {
        List<Food> food = foodRepository.findAll();

        return food;
    }

    public Food getFood(int id) {
        Food food = foodRepository.findById(id);

        return food;
    }

    public List<Food> getFoodByAmount(int amount) {
        List<Food> food = foodRepository.findAmount(amount);

        return food;
    }

    public boolean insertFood(Food food) {
        food.setDateCreated(LocalDateTime.now());
        food.setDateUpdated(LocalDateTime.now());
        int insertStatus = foodRepository.save(food);
        boolean status = false;
        if (insertStatus == 0)
        {
            status = false;
        }
        else {
            status = true;
        }
        return status;
    }
}
