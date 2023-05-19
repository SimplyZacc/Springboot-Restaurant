package com.example.restaurant.repository;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.example.restaurant.data.model.Role;

@Repository
public class RoleRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Role findByName(String name) {
    Role role = jdbcTemplate.queryForObject("SELECT * FROM role WHERE role_name=?",
        BeanPropertyRowMapper.newInstance(Role.class), name);

    return role;
  }

  public Set<Role> findByUserId(Long userId) {
    return new HashSet<>(jdbcTemplate.query(
        "SELECT role_name, role.role_id FROM role LEFT JOIN user_role ON user_role.role_id = role.role_id WHERE user_role.user_id = ?",
        BeanPropertyRowMapper.newInstance(Role.class), userId));
  }

  public void save(Long userId) {
    jdbcTemplate.update(
        "INSERT INTO user_role (user_id, role_id) VALUES(?,?)",
        new Object[] {
            userId, 1
        });
  }

}
