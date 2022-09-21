package com.example.tobyspring3.user.domain.dao;

import com.example.tobyspring3.user.domain.User;

import java.sql.*;

public class UserDaoV2 {
    public void add(User user) throws SQLException {
        final Connection c = getConnection();
        final PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws SQLException {
        final Connection c = getConnection();
        final PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?");
        ps.setString(1, id);

        final ResultSet rs = ps.executeQuery();
        rs.next();
        User user = User.builder()
                .id(rs.getString("id"))
                .name(rs.getString("name"))
                .password(rs.getString("password"))
                .build();

        rs.close();
        ps.close();
        c.close();

        return user;
    }
    private Connection getConnection() throws SQLException {
        final Connection c = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/test", "sa", "");
        return c;
    }
}
