package com.example.cadeaucommun.BLL.Model;

public class Cadeau {
    private static int auto_id = -1;
    private int id;
    private String title;
    private String description;
    private double goal;

    public Cadeau(String title, String description, double goal) {
        this.id = auto_id++;
        this.title = title;
        this.description = description;
        this.goal = goal;
    }

    public Cadeau() { }

    @Override
    public String toString() {
        return "Cadeau{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", goal=" + goal +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public double getGoal() {
        return goal;
    }
    public void setGoal(double goal) {
        this.goal = goal;
    }
}
