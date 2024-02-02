package ru.geekbrain.example3sem3hometask.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.geekbrain.example3sem3hometask.domain.User;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        return jdbcTemplate.query(sql, new UserMapper());
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge());
        return user;
    }

    public void initTable() {
        String sql = "CREATE TABLE IF NOT EXISTS userTable(name VARCHAR,age integer,email VARCHAR);";
        jdbcTemplate.update(sql);
    }
}