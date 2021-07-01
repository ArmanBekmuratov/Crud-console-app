package com.arman.crud.controller;

import com.arman.crud.model.Skill;
import com.arman.crud.model.Team;
import com.arman.crud.model.TeamStatus;
import com.arman.crud.repo.TeamRepo;
import com.arman.crud.service.TeamService;
import com.arman.crud.service.impl.TeamServiceImpl;

import java.util.List;

public class TeamController {
    TeamService teamService = new TeamServiceImpl();

    public List<Team> getAll() {
        return teamService.getAll();
    }

    public Team getById(Integer id)  {
        return teamService.getById(id);
    }

    public Team save(String name, List<Integer> developerIds, TeamStatus teamStatus) {
        return teamService.save(name, developerIds, teamStatus);
    }

    public void update(Integer id, String name, List<Integer> developerIds, TeamStatus teamStatus) {
        teamService.update(id, name, developerIds, teamStatus);
    }

    public void deleteById(Integer id)  {
        teamService.deleteById(id);
    }
}
