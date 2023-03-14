package com.example.restaurant.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.example.restaurant.data.model.Food;

@Repository
public class FoodRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Food> findAll() {
        return jdbcTemplate.query("SELECT * from food", BeanPropertyRowMapper.newInstance(Food.class));
    }

    public Food findById(int id) {
        Food food = jdbcTemplate.queryForObject("SELECT * FROM food WHERE food_id=?",
                BeanPropertyRowMapper.newInstance(Food.class), id);

        return food;
    }

    public List<Food> findAmount(int amount) {
        return jdbcTemplate.query("SELECT TOP (?) * FROM food",
                BeanPropertyRowMapper.newInstance(Food.class), amount);
    }

    public int save(Food food) {
        return jdbcTemplate.update(
                "INSERT INTO food (food_type_id, food_name, price,image_url) VALUES(?,?,?,?)",
                new Object[] { food.getFoodTypeId(), food.getFoodName(), food.getPrice(), food.getImageUrl()
                });
    }

    public int update(Food food, int id) {
        return jdbcTemplate.update(
                "UPDATE food SET food_type_id=?, food_name=?, price=?,image_url=?, date_created=?, date_updated=? WHERE food_id=?",
                new Object[] { food.getFoodTypeId(), food.getFoodName(), food.getPrice(), food.getImageUrl(),
                        food.getDateCreated(), food.getDateUpdated(), id });
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM food WHERE food_id=?", id);
    }
}
