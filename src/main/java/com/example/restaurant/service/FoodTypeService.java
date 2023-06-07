package com.example.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restaurant.data.model.FoodType;
import com.example.restaurant.repository.FoodTypeRepository;

@Service
public class FoodTypeService {
    private final FoodTypeRepository foodTypeRepository;

    public FoodTypeService(FoodTypeRepository foodTypeRepository) {
        this.foodTypeRepository = foodTypeRepository;
    }

    public List<FoodType> getAllFoodTypes() {
        return foodTypeRepository.findAll();
    }

    public FoodType getFoodType(int id) {
        return foodTypeRepository.findById(id);
    }

    public boolean insertFoodType(FoodType food) {
        int insertStatus = foodTypeRepository.save(food);

        if (insertStatus == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateFoodType(int id, FoodType food) {
        int updateStatus = foodTypeRepository.update(food, id);

        if (updateStatus == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteFoodType(int id) {
        int deleteStatus = foodTypeRepository.deleteById(id);
        if (deleteStatus == 0) {
            return false;
        } else {
           return true;
        }
    }
}
