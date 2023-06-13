package com.example.restaurant.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

import com.example.restaurant.data.model.Inventory;
import com.example.restaurant.service.InventoryService;

@RestController
@RequestMapping(path = { "/api/inventory" }, produces = APPLICATION_JSON_VALUE)
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService)
    {
        this.inventoryService = inventoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<Inventory>> getAllInventoryItems() {
        final List<Inventory> inventoryList = inventoryService.getAllInventoryItems();
        return ResponseEntity.ok(inventoryList);
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<Inventory> getInventoryItem(@PathVariable(value = "inventoryId") int id) {
        final Inventory inventoryItem = inventoryService.getInventoryItem(id);
        return ResponseEntity.ok(inventoryItem);
    }

    @PostMapping(path = "/", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventory> createInventoryItem(@RequestBody Inventory inventory) {
        final boolean created = inventoryService.insertInventoryItem(inventory);
        if (!created) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(inventory, HttpStatus.CREATED);
    }
    
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventory> editInventoryItem(@PathVariable(value = "id") int id,@RequestBody Inventory inventoryItem)
    {
        final boolean updated = inventoryService.updateInventoryItem(id, inventoryItem);
        if (!updated) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(inventoryItem, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteInventoryItem(@PathVariable(value = "id") int id)
    {
        final boolean deleted = inventoryService.deleteInventoryItem(id);

        return ResponseEntity.ok(deleted);
    }
}
