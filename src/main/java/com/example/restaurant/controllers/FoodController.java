package com.example.restaurant.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.data.model.Food;
import com.example.restaurant.data.dto.FoodDto;
import com.example.restaurant.service.FoodService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = { "/api/food" }, produces = APPLICATION_JSON_VALUE)
public class FoodController {
    private final FoodService foodService;

    // @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/")
    public ResponseEntity<List<FoodDto>> getAllFood() {
        final List<FoodDto> foodList = foodService.getAllFoodDto();
        return ResponseEntity.ok(foodList);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<FoodDto> getFood(@PathVariable(value = "foodId") int id) {// @RequestParam(value = "name",
                                                                                 // defaultValue = "Pizza") String
                                                                                 // name) {
        final FoodDto food = foodService.getFoodDto(id);
        return ResponseEntity.ok(food);
    }

    @GetMapping("/amnt/{amount}")
    public ResponseEntity<List<FoodDto>> getFoodByAmount(@PathVariable(value = "amount") int amount)
    {
        final List<FoodDto> foodList = foodService.getAmountOfFoodDto(amount);

        return ResponseEntity.ok(foodList);
    }

    @PostMapping(path = "/", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Food> createFood(@RequestBody Food food) { // Add Food dto with typeid, name, price and image instead
        final boolean orderCreated = foodService.insertFood(food);
        if (!orderCreated) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Food> editFood(@PathVariable(value = "id") int id,@RequestBody Food food)
    {
        final boolean updatedOrder = foodService.updateFood(id, food);
        if (!updatedOrder) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteFood(@PathVariable(value = "id") int id)
    {
        final boolean deleteOrder = foodService.deleteFood(id);

        return ResponseEntity.ok(deleteOrder);
    }
}
