package com.arman.crud.service.impl;

import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;
import com.arman.crud.model.Team;
import com.arman.crud.model.TeamStatus;
import com.arman.crud.repo.DeveloperRepo;
import com.arman.crud.repo.gson.GsonDeveloperRepoImpl;
import com.arman.crud.repo.gson.GsonTeamRepoImpl;
import com.arman.crud.service.TeamService;
import java.util.List;
import java.util.stream.Collectors;

public class TeamServiceImpl implements TeamService {
    private GsonTeamRepoImpl teamRepo = new GsonTeamRepoImpl();
    private DeveloperRepo developerRepo = new GsonDeveloperRepoImpl();

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
    public Team save(String name, List<Integer> developerIds, TeamStatus teamStatus) {
        Team team = new Team();
        team.setId(teamRepo.getLastId() + 1);
        team.setName(name);
        List<Developer> developerList = developerIds.stream().map(d -> developerRepo.getById(d)).collect(Collectors.toList());
        team.setDevelopers(developerList);
        team.setTeamStatus(teamStatus);
        return teamRepo.save(team);
    }

    @Override
    public Team update(Integer id, String name, List<Integer> developerIds, TeamStatus teamStatus) {
        Team team = new Team();
        team.setId(id);
        team.setName(name);
        List<Developer> developerList = developerIds.stream().map(d -> developerRepo.getById(d)).collect(Collectors.toList());
        team.setDevelopers(developerList);
        team.setTeamStatus(teamStatus);
        teamRepo.update(team);
        return team;
    }
}
