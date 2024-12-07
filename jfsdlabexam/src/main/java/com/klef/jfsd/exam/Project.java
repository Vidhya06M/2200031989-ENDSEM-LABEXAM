package com.klef.jfsd.exam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;
    private String projectName;
    private int duration;
    private double budget;
    private String teamLead;

    // Constructor for convenience
    public Project(String projectName, int duration, double budget, String teamLead) {
        this.projectName = projectName;
        this.duration = duration;
        this.budget = budget;
        this.teamLead = teamLead;
    }

    // Getters and setters
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return "Project{id=" + id + ", projectName='" + projectName + "', duration=" + duration + ", budget=" + budget + ", teamLead='" + teamLead + "'}";
    }
}
