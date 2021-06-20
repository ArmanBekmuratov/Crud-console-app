package com.arman.crud.repo.gson;

import com.arman.crud.model.Skill;
import com.arman.crud.model.Team;
import com.arman.crud.repo.TeamRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class GsonTeamRepoImpl implements TeamRepo {
    private static final String FILENAME = "teams.json";

    private static final Type SKILL_TYPE = new TypeToken<List<Team>>() {
    }.getType();
    Gson gson = new Gson();
    JsonReader reader;


    {
        try {
            reader = new JsonReader(new FileReader(FILENAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    List<Team> teamList = gson.fromJson(reader, SKILL_TYPE); // contains the whole reviews list


    public List<Team> readFile() {
        return teamList;
    }

    private void writeFile(List<Team> teamList) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try (FileWriter writer = new FileWriter(FILENAME)) {
            writer.write(gson.toJson(teamList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Team save(Team  team) {
        List<Team> teamList = readFile();
        team.setId(getLastId());
        teamList.add(team);
        writeFile(teamList);
        return team;
    }

    @Override
    public Team getById(Integer id) {
        return readFile().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Team> getAll() {
        return readFile();
    }

    @Override
    public Team update(Team team) {
        deleteById(team.getId());
        save(team);
        return team;
    }

    @Override
    public void deleteById(Integer id) {
        List<Team> teamList = readFile();
        teamList.removeIf(s -> s.getId().equals(id));
        writeFile(teamList);
    }

    private Integer getLastId() {
        return readFile().stream().map(Team::getId).findFirst().orElse(1);
    }
}
