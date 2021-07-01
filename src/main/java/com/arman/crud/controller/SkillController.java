package com.arman.crud.controller;

import com.arman.crud.model.Skill;
import com.arman.crud.service.SkillService;
import com.arman.crud.service.impl.SkillServiceImpl;

import java.util.List;

public class SkillController {
    SkillService skillService = new SkillServiceImpl();

    public List<Skill> getAll() {

        return skillService.getAll();
    }



    public Skill getById(Integer id)  {
        return skillService.getById(id);
    }

    public Skill save(String name) {
        return skillService.save(name);
    }

    public void update(Integer id, String name) {
        skillService.update(id, name);
    }

    public void deleteById(Integer id)  {
        skillService.deleteById(id);
    }
}
