package com.example.tobyspring3.user.domain.dao;

public class DaoFactory {
    public UserDaoV6 userDaoV6() {
        return new UserDaoV6(getConnectionMaker());
    }

    private static ConnectionMaker getConnectionMaker() {
        return new DConnectionMaker();
    }
}
