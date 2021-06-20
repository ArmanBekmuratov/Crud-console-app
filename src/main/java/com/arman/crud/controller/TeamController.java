package com.arman.crud.controller;

import com.arman.crud.model.Skill;
import com.arman.crud.model.Team;
import com.arman.crud.repo.TeamRepo;
import com.arman.crud.service.TeamService;

import java.util.List;

public class TeamController {
    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    public List<Team> getAll() {
        return teamService.getAll();
    }

    public Team getById(Integer id)  {
        return teamService.getById(id);
    }

    public Team save(String name) {
        return teamService.save(name);
    }

    public void update(Integer id, String name) {
        teamService.update(id, name);
    }

    public void deleteById(Integer id)  {
        teamService.deleteById(id);
    }
}
