package com.example.restaurant.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.restaurant.data.dto.FoodDto;
import com.example.restaurant.data.model.Food;
import com.example.restaurant.repository.FoodRepository;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<FoodDto> getAllFoodDto() {
        List<Food> foods = foodRepository.findAll();
        List<FoodDto> foodList = new ArrayList<FoodDto>();

        for (Food food : foods) {
            foodList.add(new FoodDto(food.getFoodTypeId(), food.getFoodName(), food.getPrice(), food.getImageUrl()));
        }
        

        return foodList;
    }

    public FoodDto getFoodDto(int id) {
        Food food = foodRepository.findById(id);

        return new FoodDto(food.getFoodTypeId(), food.getFoodName(), food.getPrice(), food.getImageUrl());
    }

    public List<FoodDto> getAmountOfFoodDto(int amount) {
        List<Food> foods = foodRepository.findAmount(amount);
        List<FoodDto> foodList = new ArrayList<FoodDto>();

        for (Food food : foods) {
            foodList.add(new FoodDto(food.getFoodTypeId(), food.getFoodName(), food.getPrice(), food.getImageUrl()));
        }

        return foodList;
    }

    public boolean insertFood(Food food) {
        // food.setDateCreated(LocalDateTime.now());
        // food.setDateUpdated(LocalDateTime.now());
        int insertStatus = foodRepository.save(food);
        boolean status = false;
        if (insertStatus == 0) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }
    
    public boolean updateFood(int id, Food food) {

        // food.setDateUpdated(LocalDateTime.now());

        int updateStatus = foodRepository.update(food, id);

        boolean status = false;
        if (updateStatus == 0) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }
    
    public boolean deleteFood(int id) {
        int deleteStatus = foodRepository.deleteById(id);
        
        boolean status =false;
        if (deleteStatus == 0) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }
}
