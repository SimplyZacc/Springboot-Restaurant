package com.example.restaurant.service;

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

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFood(int id) {
        return foodRepository.findById(id);
    }

    public List<Food> getAmountOfFood(int amount) {
        return foodRepository.findAmount(amount);
    }

    public boolean insertFood(Food food) {
        int insertStatus = foodRepository.save(food);

        if (insertStatus == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateFood(int id, Food food) {
        int updateStatus = foodRepository.update(food, id);

        if (updateStatus == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteFood(int id) {
        int deleteStatus = foodRepository.deleteById(id);
        if (deleteStatus == 0) {
            return false;
        } else {
           return true;
        }
    }
}
