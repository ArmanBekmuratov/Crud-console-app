package com.arman.crud.model;

import java.util.List;

public class Team {
    private Integer id;
    private String name;
    private List<Developer> developers;
    private TeamStatus teamStatus;

    public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }

    public Team(Integer id, String name, List<Developer> developers) {
        this.id = id;
        this.name = name;
        this.developers = developers;
    }

    public Team() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers +
                ", teamStatus=" + teamStatus +
                '}';
    }
}
