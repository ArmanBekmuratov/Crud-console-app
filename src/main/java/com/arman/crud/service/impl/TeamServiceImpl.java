package com.arman.crud.service.impl;

import com.arman.crud.model.Skill;
import com.arman.crud.model.Team;
import com.arman.crud.repo.TeamRepo;
import com.arman.crud.service.TeamService;

import java.awt.event.TextEvent;
import java.util.List;

public class TeamServiceImpl implements TeamService {
   TeamRepo teamRepo;

    public TeamServiceImpl(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    @Override
    public Team getById(Integer id) {
        return teamRepo.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        teamRepo.deleteById(id);
    }

    @Override
    public List<Team> getAll() {
        return teamRepo.getAll();
    }

    @Override
    public Team save(String name) {
        Team team = new Team();
        team.setName(name);
        return teamRepo.save(team);
    }

    @Override
    public Team update(Integer id, String name) {
        Team team = new Team();
        team.setId(id);
        team.setName(name);
        teamRepo.update(team);
        return team;
    }
}
