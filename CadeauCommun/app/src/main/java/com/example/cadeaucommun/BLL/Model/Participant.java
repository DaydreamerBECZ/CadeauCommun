package com.example.cadeaucommun.BLL.Model;

public class Participant {
    private static int auto_id = -1;
    private int id;
    private String fName;
    private String lName;
    private String username;
    private String password;
    private String image;

    public Participant(String fName, String lName, String username, String password, String image) {
        this.id = auto_id++;
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public Participant() { }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", firstName='" + fName + '\'' +
                ", lastName='" + lName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
