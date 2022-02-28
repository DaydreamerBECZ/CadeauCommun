package com.example.cadeaucommun.BLL.Model;

public class Participant extends User{


    public Participant(String name, String img) {
        super(name, img);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                '}';
    }
}
