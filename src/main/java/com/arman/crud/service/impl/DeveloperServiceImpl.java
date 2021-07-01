package com.arman.crud.service.impl;

import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;
import com.arman.crud.repo.DeveloperRepo;
import com.arman.crud.repo.SkillRepo;
import com.arman.crud.repo.gson.GsonDeveloperRepoImpl;
import com.arman.crud.repo.gson.GsonSkillRepoImpl;
import com.arman.crud.service.DeveloperService;

import java.util.List;
import java.util.stream.Collectors;

public class DeveloperServiceImpl implements DeveloperService {

    private GsonDeveloperRepoImpl developerRepo = new GsonDeveloperRepoImpl();
    private SkillRepo skillRepo = new GsonSkillRepoImpl();


    public DeveloperServiceImpl() {
    }

    @Override
    public List<Developer> getAll() {
        return developerRepo.getAll();
    }

    @Override
    public Developer getById(Integer id) {
        return developerRepo.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        developerRepo.deleteById(id);
    }

    @Override
    public Developer save(String firstName, String lastName,List<Integer> skillIds) {
        Developer developer = new Developer();
        developer.setId(developerRepo.getLastId() + 1);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        List<Skill> skills = skillIds.stream().map(s -> skillRepo.getById(s)).collect(Collectors.toList());
        developer.setSkills(skills);
        return developerRepo.save(developer);
    }

    @Override
    public Developer update(Integer id, String firstName, String lastName,List<Integer> skillIds) {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        List<Skill> skills = skillIds.stream().map(s -> skillRepo.getById(s)).collect(Collectors.toList());
        developer.setSkills(skills);
        developerRepo.update(developer);
        return developer;
    }
}
