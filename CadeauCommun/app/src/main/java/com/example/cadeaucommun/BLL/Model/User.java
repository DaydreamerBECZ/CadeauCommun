package com.example.cadeaucommun.BLL.Model;
@Deprecated
public abstract class User {
    private static int auto_id = 0;
    private int id;
    private String img;
    private String fName, lName;

    public User(String fName, String lName, String img) {
        this.id=auto_id;
        this.fName = fName;
        this.lName = lName;
        this.img = img;
        auto_id++;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.fName + " " + this.lName;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
