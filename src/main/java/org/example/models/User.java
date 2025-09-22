package org.example.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String login;
    private LocalDateTime createdAt;

    public User(int id, String login) {
        this.id = id;
        this.login = login;
        this.createdAt = LocalDateTime.now();
    }
}
