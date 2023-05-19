package com.example.restaurant.data.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.restaurant.repository.RoleRepository;


public class User {
  private Long id;
  private String username;
  private String email;
  private String password;
  private Set<Role> roles = new HashSet<>();

  @Autowired
  RoleRepository roleRepository;

  public User() {
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    dataSource.setUrl("jdbc:sqlserver://LAPTOP-4C4TUAER;databaseName=food;trustServerCertificate=true");
    dataSource.setUsername("Tester");
    dataSource.setPassword("Test@123");

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    Set<Role> newRoles = new HashSet<>(jdbcTemplate.query(
        "SELECT role_name as name, role.role_id as id FROM role LEFT JOIN user_role ON user_role.role_id = role.role_id WHERE user_role.user_id = ?",
        BeanPropertyRowMapper.newInstance(Role.class), this.id));

    return newRoles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
