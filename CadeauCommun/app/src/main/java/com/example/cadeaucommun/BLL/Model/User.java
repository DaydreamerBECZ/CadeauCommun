package com.example.cadeaucommun.BLL.Model;

public abstract class User {
    private static int auto_id = 0;
    private int id;
    private String img;
    private String name;

    public User(String name, String img) {
        this.id=auto_id;
        this.name = name;
        this.img = img;
        auto_id++;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
