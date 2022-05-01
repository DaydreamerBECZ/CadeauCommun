package com.example.cadeaucommun.BLL.Model;

@Deprecated
public class ParticipantOld extends User{

    public ParticipantOld(String fName, String lName, String img) {
        super(fName, lName, img);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
