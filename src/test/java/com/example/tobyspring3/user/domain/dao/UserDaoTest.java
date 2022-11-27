package com.example.tobyspring3.user.domain.dao;

import com.example.tobyspring3.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

class UserDaoTest {
//    UserDao dao = new UserDaoV1();
//    UserDao dao = new UserDaoV2.NUserDao();
//    UserDao dao = new UserDaoV3(new DConnectionMaker());
//    UserDao dao = new DaoFactory().userDao();
//    UserDao dao = new DaoFactory().userDao();
    UserDao dao;

    public UserDaoTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        this.dao = context.getBean("userDao", UserDao.class);
    }

    @Test
    void test() throws SQLException {
        final User user = User.builder()
                .id("whiteship")
                .name("백기선")
                .password("married")
                .build();

        this.dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        final User user2 = this.dao.get(user.getId());
        System.out.println("user2.getName() = " + user2.getName());
        System.out.println("user2.getPassword() = " + user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}