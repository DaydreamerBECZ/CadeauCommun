package com.example.cadeaucommun.BLL.Model;

import java.util.ArrayList;
import java.util.List;

public class Gift {
    private static int auto_id = 0;
    private int id;
    private String title;
    private String description;
    private String image;
    private double goal;
    private List<Participant> invitees;

    public Gift(String title, String description, String image, double goal) {
        this.id=auto_id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.goal = goal;
        //this.invitees = fetchAllSelectedParticipants();
        auto_id++;
    }

    public Gift(String title, String description, double goal) {
        this.id = auto_id;
        this.title = title;
        this.description = description;
        this.goal = goal;
        auto_id++;
    }



    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public double getGoal() {
        return goal;
    }
    public void setGoal(double goal) {
        this.goal = goal;
    }
}
