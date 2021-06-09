package com.arman.crud.service.impl;

import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;
import com.arman.crud.repo.DeveloperRepo;
import com.arman.crud.service.DeveloperService;

import java.util.List;

public class DeveloperServiceImpl implements DeveloperService {

    private DeveloperRepo developerRepo;

    public DeveloperServiceImpl(DeveloperRepo developerRepo) {
        this.developerRepo = developerRepo;
    }

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
    public Developer save(String firstName, String lastName) {
        Developer developer = new Developer();
        developer.setId(developerRepo.getLastId() + 1);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        return developerRepo.save(developer);
    }

    @Override
    public Developer update(Integer id, String firstName, String lastName, List<Skill> skillList) {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setSkills(skillList);
        developerRepo.update(developer);
        return developer;
    }
}
