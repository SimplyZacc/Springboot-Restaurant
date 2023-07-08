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

import com.example.restaurant.data.model.Feedback;

@Repository
public class FeedbackRepository {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Feedback> findAll() {
        List<Feedback> feedback = new ArrayList<>();
        try {
            feedback = jdbcTemplate.query(
                    "SELECT [feedback_id] as feedbackId " +
                            ",[order_id] as orderId " +
                            ",[feedback_text] as feedbackText " +
                            ",[first_name] as fName " +
                            ",[last_name] as lName " +
                            ",[email] " +
                            ",[date_created] as dateCreated " +
                            ",[date_updated] as dateUpdated " +
                            "FROM feedback",
                    BeanPropertyRowMapper.newInstance(Feedback.class));
        } catch (Exception e) {
            logger.error("Error getting all feedback from feedback table: {}", e);
        }
        return feedback;
    }

    public Feedback findById(int id) {
        Feedback food = new Feedback();
        try {
            food = jdbcTemplate.queryForObject(
                    "SELECT [feedback_id] as feedbackId " +
                            ",[order_id] as orderId " +
                            ",[feedback_text] as feedbackText " +
                            ",[first_name] as fName " +
                            ",[last_name] as lName " +
                            ",[email] " +
                            ",[date_created] as dateCreated " +
                            ",[date_updated] as dateUpdated " +
                            "FROM feedback WHERE [order_id]=?",
                    BeanPropertyRowMapper.newInstance(Feedback.class), id);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Error trying to get record with order id {} from feedback table: {}", id, e);
        } catch (Exception e) {
            logger.error("Error trying to get record with order id {} from feedback table: {}", id, e);
        }
        return food;
    }

    public int save(Feedback feedback) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "INSERT INTO feedback ([order_id] ,[feedback_text] ,[first_name] ,[last_name] ,[email]) VALUES(?,?,?,?,?)",
                    new Object[] { feedback.getOrderId(), feedback.getFeedbackText(), feedback.getfName(),
                            feedback.getlName(), feedback.getEmail()
                    });
        } catch (Exception e) {
            logger.error("Error adding Food Type to feedback table: {}", e);
        }
        return updated;
    }

    public int update(Feedback feedback, int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update(
                    "UPDATE feedback SET [feedback_text]=?, [first_name]=?, [last_name]=?, [email]=?, date_updated=? WHERE [order_id]=?",
                    new Object[] {feedback.getFeedbackText(), feedback.getfName(),
                            feedback.getlName(), feedback.getEmail(), LocalDateTime.now(),
                            id });
        } catch (Exception e) {
            logger.error("Error updating food type in feedback table: {}", e);
        }
        return updated;
    }

    public int deleteById(int id) {
        int updated = 0;
        try {
            updated = jdbcTemplate.update("DELETE FROM feedback WHERE [order_id]=?", id);
        } catch (Exception e) {
            logger.error("Error deleting food type from feedback table: {}", e);
        }
        return updated;
    }

}
