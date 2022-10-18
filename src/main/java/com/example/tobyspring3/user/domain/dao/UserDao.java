package com.example.tobyspring3.user.domain.dao;

import com.example.tobyspring3.user.domain.User;

import java.sql.SQLException;

public interface UserDao {
    void add(User user) throws SQLException;
    User get(String id) throws SQLException;
    void deleteAll() throws SQLException;
    int getCount() throws SQLException;
}
