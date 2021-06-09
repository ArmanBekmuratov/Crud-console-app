package com.arman.crud.service;

import com.arman.crud.model.Skill;

public interface SkillService extends GenericService<Skill> {
    Skill save(String name);

    Skill update(Integer id,String name);
}
