package com.example.tobyspring3.user.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class User {
    private final String id;
    private final String name;
    private final String password;
}