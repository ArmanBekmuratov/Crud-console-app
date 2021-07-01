package com.arman.crud.service.impl;

import com.arman.crud.model.Skill;
import com.arman.crud.repo.SkillRepo;
import com.arman.crud.repo.gson.GsonSkillRepoImpl;
import com.arman.crud.service.SkillService;

import java.util.List;

public class SkillServiceImpl implements SkillService {

    private GsonSkillRepoImpl skillRepo = new GsonSkillRepoImpl();

    public SkillServiceImpl() {
    }

    @Override
    public Skill getById(Integer id) {
        return skillRepo.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        skillRepo.deleteById(id);
    }

    @Override
    public List<Skill> getAll() {
        return skillRepo.getAll();
    }

    @Override
    public Skill save(String name) {
        Skill skill = new Skill();
        skill.setId(skillRepo.getLastId() + 1);
        skill.setName(name);
        return skillRepo.save(skill);
    }

    @Override
    public Skill update(Integer id, String name) {
        Skill  skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        skillRepo.update(skill);
        return skill;
    }
}
