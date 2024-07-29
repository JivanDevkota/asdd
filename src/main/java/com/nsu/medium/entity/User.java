package com.nsu.medium.entity;

import jakarta.persistence.Id;

public class User {

    @Id
    private Long id;

    private String email;
    private String username;
    private String password;
}
