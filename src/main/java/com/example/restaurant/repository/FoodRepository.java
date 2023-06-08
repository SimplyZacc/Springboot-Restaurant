package com.example.restaurant.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.example.restaurant.data.model.Food;

@Repository
public class FoodRepository {

    private static final Logger logger = LoggerFactory.getLogger(FoodRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Food> findAll() {
        List<Food> foods = new ArrayList<Food>();
        try {
            foods = jdbcTemplate.query(
                    "SELECT [food_id] as id, [food_type_id] as foodTypeId, [food_name] as foodName, [price], [image_url] as imageUrl, [date_created], [date_updated] FROM food",
                    BeanPropertyRowMapper.newInstance(Food.class));
        } catch (Exception e) {
            logger.error("Error getting all foods from food table: {}", e);
        }
        return foods;
    }

    public Food findById(int id) {
        Food food = new Food();
        try {
            food = jdbcTemplate.queryForObject(
                    "SELECT [food_id] as id, [food_type_id] as foodTypeId, [food_name] as foodName, [price], [image_url] as imageUrl, [date_created], [date_updated] FROM food WHERE food_id=?",
                    BeanPropertyRowMapper.newInstance(Food.class), id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Error trying to get record with id {} from food table: {}", id, e);
        } catch (Exception e) {
            logger.error("Error trying to get record with id {} from food table: {}", id, e);
        }
        return food;
    }

    public List<Food> findAmount(int amount) {
        List<Food> foods = new ArrayList<Food>();
        try {
            foods = jdbcTemplate.query(
                    "SELECT TOP (?) [food_id] as id, [food_type_id] as foodTypeId, [food_name] as foodName, [price], [image_url] as imageUrl, [date_created], [date_updated] FROM food",
                    BeanPropertyRowMapper.newInstance(Food.class),amount);
        } catch (Exception e) {
            logger.error("Error getting {} foods from food table: {}", amount, e);
        }
        return foods;
    }

    public int save(Food food) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "INSERT INTO food (food_type_id, food_name, price,image_url) VALUES(?,?,?,?)",
                    new Object[] { food.getFoodTypeId(), food.getFoodName(), food.getPrice(), food.getImageUrl()
                    });
        } catch (Exception e) {
            logger.error("Error adding food to food table: {}", e);
        }
        return updated;
    }

    public int update(Food food, int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "UPDATE food SET food_type_id=?, food_name=?, price=?,image_url=?, date_updated=? WHERE food_id=?",
                    new Object[] { food.getFoodTypeId(), food.getFoodName(), food.getPrice(), food.getImageUrl(),
                            LocalDateTime.now(), id });
        } catch (Exception e) {
            logger.error("Error adding food to food table: {}", e);
        }
        return updated;
    }

    public int deleteById(int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update("DELETE FROM food WHERE food_id=?", id);
        } catch (Exception e) {
            logger.error("Error adding food to food table: {}", e);
        }
        return updated;
    }
}
