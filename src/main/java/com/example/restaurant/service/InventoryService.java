package com.example.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restaurant.data.model.Inventory;
import com.example.restaurant.repository.InventoryRepository;

@Service
public class InventoryService {
    
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryItem(int id) {
        return inventoryRepository.findById(id);
    }

    public boolean insertInventoryItem(Inventory inventoryItem) {
        int insertStatus = inventoryRepository.save(inventoryItem);

        if (insertStatus == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateInventoryItem(int id, Inventory inventoryItem) {
        int updateStatus = inventoryRepository.update(inventoryItem, id);

        if (updateStatus == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteInventoryItem(int id) {
        int deleteStatus = inventoryRepository.deleteById(id);
        if (deleteStatus == 0) {
            return false;
        } else {
           return true;
        }
    }
}
