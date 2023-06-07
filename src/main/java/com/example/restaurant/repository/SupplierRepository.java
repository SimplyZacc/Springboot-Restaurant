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

import com.example.restaurant.data.model.Supplier;

@Repository
public class SupplierRepository {

    private static final Logger logger = LoggerFactory.getLogger(FoodTypeRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Supplier> findAll() {
        List<Supplier> suppliers = new ArrayList<Supplier>();
        try {
            suppliers = jdbcTemplate.query(
                    "SELECT [supplier_id] as supplierId, [supplier_name] as supplierName, [phone_no] as phoneNo, [address1], [address2], [parish], [is_active] as isActive, [date_created], [date_updated] FROM supplier",
                    BeanPropertyRowMapper.newInstance(Supplier.class));
        } catch (Exception e) {
            logger.error("Error getting all suppliers from supplier table: {}", e);
        }
        return suppliers;
    }

    public Supplier findById(int id) {
        Supplier food = new Supplier();
        try {
            food = jdbcTemplate.queryForObject(
                    "SELECT [supplier_id] as supplierId, [supplier_name] as supplierName, [phone_no] as phoneNo, [address1], [address2], [parish], [is_active] as isActive, [date_created], [date_updated] FROM supplier WHERE supplier_id=?",
                    BeanPropertyRowMapper.newInstance(Supplier.class), id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Error trying to get record with id {} from supplier table: {}", id, e);
        } catch (Exception e) {
            logger.error("Error trying to get record with id {} from supplier table: {}", id, e);
        }
        return food;
    }

    public int save(Supplier supplier) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "INSERT INTO supplier ([supplier_name], [phone_no], [address1], [address2], [parish], [is_active]) VALUES(?,?,?,?,?,?)",
                    new Object[] { supplier.getSupplierName(), supplier.getPhoneNo(), supplier.getAddress1(), supplier.getAddress2(), supplier.getParish(), supplier.getIsActive()
                    });
        } catch (Exception e) {
            logger.error("Error adding Food Type to foodtype table: {}", e);
        }
        return updated;
    }

    public int update(Supplier supplier, int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "UPDATE supplier SET [supplier_name]=?, [phone_no]=?, [address1]=?, [address2]=?, [parish]=?, [is_active]=?, date_updated=? WHERE [supplier_id]=?",
                    new Object[] { supplier.getSupplierName(), supplier.getPhoneNo(), supplier.getAddress1(), supplier.getAddress2(), supplier.getParish(), supplier.getIsActive(), LocalDateTime.now(), id });
        } catch (Exception e) {
            logger.error("Error updating food type in foodtype table: {}", e);
        }
        return updated;
    }

    public int deleteById(int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update("DELETE FROM supplier WHERE supplier_id=?", id);
        } catch (Exception e) {
            logger.error("Error deleting food type from foodtype table: {}", e);
        }
        return updated;
    }

}
