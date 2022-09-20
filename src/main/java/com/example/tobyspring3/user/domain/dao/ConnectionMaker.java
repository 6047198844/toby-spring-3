package com.example.tobyspring3.user.domain.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection getConnection() throws SQLException;
}
