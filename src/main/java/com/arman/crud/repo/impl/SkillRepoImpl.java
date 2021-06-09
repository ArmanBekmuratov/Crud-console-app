package com.arman.crud.repo.impl;

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

public class SkillRepoImpl implements SkillRepo {

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

    @Override
    public void writeFile(List<Skill> skillList) {
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
        List <Skill> skillList = readFile();
        if (skillList == null) {
            skillList = new ArrayList<>();
            skillList.add(skill);
        } else if (skillList.isEmpty()) {
            skillList.add(skill);
        } else if (!skillList.contains(skill)) {
            skillList.add(skill);
        }

        writeFile(skillList);
        return skill;
    }

    @Override
    public Skill getById(Integer id) {
        List <Skill> skillList = readFile();
        Skill skill = null;
        for (Skill s : skillList) {
            if (s.getId().equals(id)) {
                skill = s;
                break;
            }
        }
        return skill;
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
        List <Skill> skillList = readFile();

        skillList.removeIf(s -> s.getId().equals(id));
        writeFile(skillList);
    }

    @Override
    public Integer getLastId() {
        List<Skill> skillList = readFile();
        Collections.sort(skillList, Comparator.comparing(Skill::getId));

        if (skillList.size() != 0) {
            return skillList.get(skillList.size() - 1).getId();
        }

        return 0;
    }
}
