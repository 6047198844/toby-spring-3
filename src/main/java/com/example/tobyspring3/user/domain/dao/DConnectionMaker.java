package com.example.tobyspring3.user.domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws SQLException {
        final Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/test", "sa", "");
        return c;
    }
}
