package ru.geekbrain.example3sem3hometask.repository;


import org.springframework.jdbc.core.RowMapper;
import ru.geekbrain.example3sem3hometask.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setEmail(resultSet.getString("email"));

        return user;
    }
}