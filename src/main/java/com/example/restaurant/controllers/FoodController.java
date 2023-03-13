package com.example.restaurant.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.data.model.Food;
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
    public ResponseEntity<List<Food>> getAllFood() {
        final List<Food> food = foodService.getAllFood();
        return ResponseEntity.ok(food);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<Food> getFood(@PathVariable(value = "foodId") int id) {// @RequestParam(value = "name",
                                                                                 // defaultValue = "Pizza") String
                                                                                 // name) {
        final Food food = foodService.getFood(id);
        return ResponseEntity.ok(food);
    }

    @GetMapping("/{amount}")
    public ResponseEntity<List<Food>> getFoodByAmount(@PathVariable(value = "amount") int amount)
    {
        final List<Food> food = foodService.getFoodByAmount(amount);

        return ResponseEntity.ok(food);
    }

    @PostMapping(path = "/", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        final boolean updatedOrder = foodService.insertFood(food);
        if (!updatedOrder) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(food,HttpStatus.CREATED);
    }
}
