package com.example.tobyspring3.user.domain.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DaoFactoryV2 {
    @Bean
    public UserDao userDao() {
        return new UserDaoV5(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(
                "jdbc:h2:tcp://localhost/~/test", "sa", "");
    }

    @Bean
    public DataSource dataSource2() {
        return new DriverManagerDataSource(
                "jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
