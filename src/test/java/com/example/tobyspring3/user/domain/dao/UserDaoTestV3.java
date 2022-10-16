package com.example.tobyspring3.user.domain.dao;

import com.example.tobyspring3.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

class UserDaoTestV3 {
    @Test
    void test() throws SQLException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CounterDaoFactory.class);
        final UserDaoV4 dao = context.getBean("userDao", UserDaoV4.class);

        final User user = User.builder()
                .id("whiteship")
                .name("백기선")
                .password("married")
                .build();
        dao.add(user);

        final User user2 = User.builder()
                .id("whiteship2")
                .name("백기선2")
                .password("married2")
                .build();
        dao.add(user2);
        System.out.println(user.getId() + " 등록 성공");
        final User user3 = dao.get(user.getId());
        System.out.println("user2.getName() = " + user2.getName());
        System.out.println("user2.getPassword() = " + user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");

        final CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());
    }
}