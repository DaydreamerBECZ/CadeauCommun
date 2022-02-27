package com.example.cadeaucommun.BLL.Model;

public class Participant extends User{
    private static int auto_id = 0;
    private int id;
    private String name;

    public Participant(String name){
        super(name);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + String.valueOf(this.name) + '\'' +
                '}';
    }

}
