package com.example.cadeaucommun.BLL.Model;

public abstract class User {
    private static int auto_id = 0;
    private int id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}
