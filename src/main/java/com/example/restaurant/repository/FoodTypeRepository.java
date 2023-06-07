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

import com.example.restaurant.data.model.FoodType;

@Repository
public class FoodTypeRepository {

    private static final Logger logger = LoggerFactory.getLogger(FoodTypeRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FoodType> findAll() {
        List<FoodType> foodTypes = new ArrayList<FoodType>();
        try {
            foodTypes = jdbcTemplate.query(
                    "SELECT [food_type_id] as foodTypeId, [food_type_name] as foodTypeName, [is_active] as isActive, [date_created], [date_updated] FROM foodtype",
                    BeanPropertyRowMapper.newInstance(FoodType.class));
        } catch (Exception e) {
            logger.error("Error getting all food types from foodtype table: {}", e);
        }
        return foodTypes;
    }

    public FoodType findById(int id) {
        FoodType food = new FoodType();
        try {
            food = jdbcTemplate.queryForObject(
                    "SELECT [food_type_id] as foodTypeId, [food_type_name] as foodTypeName, [is_active] as isActive, [date_created], [date_updated] FROM foodtype WHERE foodTypeId=?",
                    BeanPropertyRowMapper.newInstance(FoodType.class), id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Error trying to get record with id {} from foodtype table: {}", id, e);
        } catch (Exception e) {
            logger.error("Error trying to get record with id {} from foodtype table: {}", id, e);
        }
        return food;
    }

    public int save(FoodType foodType) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "INSERT INTO foodtype ([food_type_id], [food_type_name], [is_active]) VALUES(?,?,?)",
                    new Object[] { foodType.getFoodTypeId(), foodType.getFoodTypeName(), foodType.getActive()
                    });
        } catch (Exception e) {
            logger.error("Error adding Food Type to foodtype table: {}", e);
        }
        return updated;
    }

    public int update(FoodType food, int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "UPDATE foodtype SET [food_type_name]=?, [is_active]=? date_updated=? WHERE [food_type_id]=?",
                    new Object[] { food.getFoodTypeName(), food.getActive(), LocalDateTime.now(), id });
        } catch (Exception e) {
            logger.error("Error updating food type in foodtype table: {}", e);
        }
        return updated;
    }

    public int deleteById(int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update("DELETE FROM foodtype WHERE food_type_id=?", id);
        } catch (Exception e) {
            logger.error("Error deleting food type from foodtype table: {}", e);
        }
        return updated;
    }
}
