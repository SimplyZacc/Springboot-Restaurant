package com.example.restaurant.repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.example.restaurant.data.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class UserRepository {

  private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public User findByUsername(String username) {
    User user;
    try {
      user = jdbcTemplate.queryForObject(
          "SELECT user_id as id, username, email, password  FROM [food].[dbo].[user] WHERE username=?",
          BeanPropertyRowMapper.newInstance(User.class), username);
    } catch (EmptyResultDataAccessException e) {
      logger.error("Empty Result data error: {}", e.getMessage());
      user = new User();
    }

    return user;
  }

  public Boolean existsByUsername(String username) {
    boolean exists = false;
    int count;
    try {
      count = jdbcTemplate.queryForObject("SELECT count(*) FROM [food].[dbo].[user] WHERE username=?", Integer.class,
          username);
    } catch (EmptyResultDataAccessException e) {
      // log here when logging
      count = 0;
      exists = false;
    }
    exists = count > 0;
    return exists;
  }

  public Boolean existsByEmail(String email) {

    boolean exists = false;
    int count;
    try {
      count = jdbcTemplate.queryForObject("SELECT count(*) FROM [food].[dbo].[user]  WHERE email=?", Integer.class,
          email);
    } catch (EmptyResultDataAccessException e) {
      // log here when logging
      count = 0;
      exists = false;
    }
    exists = count > 0;
    return exists;
  }

  public void save(User user) {
    jdbcTemplate.update(
        "INSERT INTO [food].[dbo].[user]  (username, email, password) VALUES(?,?,?)",
        new Object[] { user.getUsername(), user.getEmail(), user.getPassword()
        });
  }

}
