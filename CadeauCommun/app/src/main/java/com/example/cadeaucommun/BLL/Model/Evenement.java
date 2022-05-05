package com.example.cadeaucommun.BLL.Model;

import com.example.cadeaucommun.DAL.ConcreteDAOs.EvenementDAO;

import java.time.LocalDate;

public class Evenement {
    private static int auto_id = -1;
    private int id;
    private String title;
    private String description;
    private LocalDate beginDate;
    private LocalDate endDate;
    private int organizerID;

    public Evenement(String title, String description, LocalDate beginDate, LocalDate endDate) {
        this.id = auto_id++;
        this.title = title;
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Evenement(){ }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
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
    public LocalDate getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
