package com.arman.crud.repo.gson;

import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;
import com.arman.crud.repo.DeveloperRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class GsonDeveloperRepoImpl implements DeveloperRepo {

    private static final String FILENAME = "C:\\Users\\abekm\\Downloads\\Crud-console-app\\Crud-console-app\\src\\main\\resources\\developers.json";

    private static final Type DEVELOPER_TYPE = new TypeToken<List<Developer>>() {
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

    List<Developer> developerList = gson.fromJson(reader, DEVELOPER_TYPE); // contains the whole reviews list


    private List<Developer> readFile() {
        return developerList;
    }

    private void writeFile(List<Developer> developerList) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try (FileWriter writer = new FileWriter(FILENAME)) {
            writer.write(gson.toJson(developerList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer getById(Integer id) {
        return readFile().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Developer> getAll() {
        return readFile();
    }

    @Override
    public Developer save(Developer developer) {
        List<Developer> developerList = readFile();
        developerList.add(developer);
        writeFile(developerList);
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
       deleteById(developer.getId());
       save(developer);
       return developer;
    }

    @Override
    public void deleteById(Integer id) {
        List<Developer> developerList = readFile();
        developerList.removeIf(d -> d.getId().equals(id));
        writeFile(developerList);
    }

    public Integer getLastId() {
        List<Developer> developerList = readFile();
        developerList.sort(Comparator.comparing(Developer::getId));

        if (developerList.size() != 0) {
            return developerList.get(developerList.size() - 1).getId();
        }

        return 0;
    }
}
