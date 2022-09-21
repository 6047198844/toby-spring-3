package com.example.tobyspring3.user.domain.dao;

import com.example.tobyspring3.user.domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDaoTest {
    @Test
    void test() throws SQLException {
        UserDaoV4 dao = new UserDaoV4();

        final User user = User.builder()
                .id("whiteship")
                .name("백기선")
                .password("married")
                .build();

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        final User user2 = dao.get(user.getId());
        System.out.println("user2.getName() = " + user2.getName());
        System.out.println("user2.getPassword() = " + user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}