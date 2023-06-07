package com.example.restaurant.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.data.model.FoodType;
import com.example.restaurant.service.FoodTypeService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(path = { "/api/food" }, produces = APPLICATION_JSON_VALUE)
public class FoodTypeController {
    private final FoodTypeService foodTypeService;

    public FoodTypeController(FoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }

    @GetMapping("")
    public ResponseEntity<List<FoodType>> getAllFoodTypes() {
        final List<FoodType> foodList = foodTypeService.getAllFoodTypes();
        return ResponseEntity.ok(foodList);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<FoodType> getFood(@PathVariable(value = "foodId") int id) {
        final FoodType food = foodTypeService.getFoodType(id);
        return ResponseEntity.ok(food);
    }

    @PostMapping(path = "/", consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_STAFF') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<FoodType> createFood(@RequestBody FoodType food) {
        final boolean orderCreated = foodTypeService.insertFoodType(food);
        if (!orderCreated) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<FoodType> editFood(@PathVariable(value = "id") int id,@RequestBody FoodType food)
    {
        final boolean updatedOrder = foodTypeService.updateFoodType(id, food);
        if (!updatedOrder) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Boolean> deleteFood(@PathVariable(value = "id") int id)
    {
        final boolean deleteOrder = foodTypeService.deleteFoodType(id);

        return ResponseEntity.ok(deleteOrder);
    }
}
