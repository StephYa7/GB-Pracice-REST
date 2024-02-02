package ru.geekbrain.example3sem3hometask.repository;

import jakarta.annotation.PostConstruct;
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
        String sql = "INSERT INTO userTable VALUES ( ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail());
        return user;
    }

    @PostConstruct
    public void initTable() {
        String sqlInitTable = "CREATE TABLE IF NOT EXISTS userTable(name VARCHAR,age integer,email VARCHAR);";
        jdbcTemplate.update(sqlInitTable);
    }
}