package com.example.tobyspring3.user.domain.dao;

import com.example.tobyspring3.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class UserDaoTestV2 {
    @Test
    void add테스트() throws SQLException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactoryV2.class);
        final UserDao dao = context.getBean("userDao", UserDao.class);

        final User user = User.builder()
                .id("gyumee")
                .name("박성철")
                .password("springno1")
                .build();

        final User user2 = User.builder()
                .id("leegw700")
                .name("이길원")
                .password("springno2")
                .build();

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user);
        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        assertThat(user).isEqualTo(dao.get("gyumee"));
        assertThat(user).isEqualTo(dao.get("leegw700"));

    }

    @Test
    void 카운트() throws SQLException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactoryV2.class);
        final UserDao dao = context.getBean("userDao", UserDao.class);

        final User user = User.builder()
                .id("gyumee")
                .name("박성철")
                .password("springno1")
                .build();

        final User user2 = User.builder()
                .id("leegw700")
                .name("이길원")
                .password("springno2")
                .build();

        final User user3 = User.builder()
                .id("bumjin")
                .name("박범진")
                .password("springno3")
                .build();

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);
    }

    @Test
    void 예외조건() throws SQLException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactoryV2.class);
        final UserDao dao = context.getBean("userDao", UserDao.class);

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        Assertions.assertThatThrownBy(() -> dao.get("unknown_id")).isInstanceOf(EmptyResultDataAccessException.class);
    }
}