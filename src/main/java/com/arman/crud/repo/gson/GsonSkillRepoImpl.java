package com.arman.crud.repo.gson;

import com.arman.crud.model.Skill;
import com.arman.crud.repo.SkillRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GsonSkillRepoImpl implements SkillRepo {

    private static final String FILENAME = "skills.json";

    private static final Type SKILL_TYPE = new TypeToken<List<Skill>>() {
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

    List<Skill> skillList = gson.fromJson(reader, SKILL_TYPE); // contains the whole reviews list


    public List<Skill> readFile() {
        return skillList;
    }

    private void writeFile(List<Skill> skillList) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try (FileWriter writer = new FileWriter(FILENAME)) {
            writer.write(gson.toJson(skillList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill save(Skill skill) {
        List<Skill> skillList = readFile();
        skill.setId(getLastId());
        skillList.add(skill);
        writeFile(skillList);
        return skill;
    }

    @Override
    public Skill getById(Integer id) {
        return readFile().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Skill> getAll() {
        return readFile();
    }

    @Override
    public Skill update(Skill skill) {
        deleteById(skill.getId());
        save(skill);
        return skill;
    }

    @Override
    public void deleteById(Integer id) {
        List<Skill> skillList = readFile();
        skillList.removeIf(s -> s.getId().equals(id));
        writeFile(skillList);
    }

    private Integer getLastId() {
        return readFile().stream().map(Skill::getId).findFirst().orElse(1);
    }
}
