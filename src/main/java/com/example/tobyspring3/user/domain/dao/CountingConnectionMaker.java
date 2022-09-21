package com.example.tobyspring3.user.domain.dao;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@Getter
@RequiredArgsConstructor
public class CountingConnectionMaker implements ConnectionMaker{
    int counter = 0;
    private final ConnectionMaker connectionMaker;

    @Override
    public Connection makeConnection() throws SQLException {
        this.counter ++;
        return connectionMaker.makeConnection();
    }
}
