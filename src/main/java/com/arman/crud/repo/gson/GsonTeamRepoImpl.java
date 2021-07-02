package com.arman.crud.repo.gson;
import com.arman.crud.model.Team;
import com.arman.crud.repo.TeamRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

public class GsonTeamRepoImpl implements TeamRepo {
    private static final String FILENAME = "C:\\Users\\abekm\\Downloads\\Crud-console-app\\Crud-console-app\\src\\main\\resources\\teams.json";

    private static final Type TEAM_TYPE = new TypeToken<List<Team>>() {
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

    List<Team> teamList = gson.fromJson(reader, TEAM_TYPE); // contains the whole reviews list


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

    public Integer getLastId() {
        List<Team> teamList = readFile();
        teamList.sort(Comparator.comparing(Team::getId));

        if (teamList.size() != 0) {
            return teamList.get(teamList.size() - 1).getId();
        }

        return 0;
    }
}
