package com.example.restaurant.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.restaurant.data.model.Inventory;

@Repository
public class InventoryRepository {
    private static final Logger logger = LoggerFactory.getLogger(InventoryRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Inventory> findAll() {
        List<Inventory> suppliers = new ArrayList<Inventory>();
        try {
            suppliers = jdbcTemplate.query(
                    "SELECT [food_id] as foodId, [supplier_id] as supplierId, amount, [min_amount] as minAmnt, [max_amount] as maxAmnt, [date_created], [date_updated] FROM inventory",
                    BeanPropertyRowMapper.newInstance(Inventory.class));
        } catch (Exception e) {
            logger.error("Error getting all inventory items from inventory table: {}", e);
        }
        return suppliers;
    }

    public Inventory findById(int id) {
        Inventory food = new Inventory();
        try {
            food = jdbcTemplate.queryForObject(
                "SELECT [food_id] as foodId, [supplier_id] as supplierId, amount, [min_amount] as minAmnt, [max_amount] as maxAmnt, [date_created], [date_updated] FROM inventory WHERE [food_id]=?",
                    BeanPropertyRowMapper.newInstance(Inventory.class), id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Error trying to get record with id {} from inventory table: {}", id, e);
        } catch (Exception e) {
            logger.error("Error trying to get record with id {} from inventory table: {}", id, e);
        }
        return food;
    }

    public int save(Inventory inventory) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "INSERT INTO inventory ([food_id], [supplier_id], [amount], [min_amount], [max_amount]) VALUES(?,?,?,?,?)",
                    new Object[] { inventory.getFoodId(), inventory.getSupplierId(), inventory.getAmount(), inventory.getMinAmnt(),
                            inventory.getMaxAmnt()
                    });
        } catch (Exception e) {
            logger.error("Error adding inventory item to inventory table: {}", e);
        }
        return updated;
    }

    public int update(Inventory inventory, int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "UPDATE supplier SET [food_id]=?, [supplier_id]=?, [amount]=?, [min_amount]=?, [max_amount]=?, [date_updated]=? WHERE [food_id]=?",
                    new Object[] { inventory.getFoodId(), inventory.getSupplierId(), inventory.getAmount(),
                            inventory.getMinAmnt(), inventory.getMaxAmnt(), LocalDateTime.now(),
                            id });
        } catch (Exception e) {
            logger.error("Error updating inventory item in inventory table: {}", e);
        }
        return updated;
    }

    public int deleteById(int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update("DELETE FROM inventory WHERE [food_id]=?", id);
        } catch (Exception e) {
            logger.error("Error deleting inventory item from inventory table: {}", e);
        }
        return updated;
    }

}
