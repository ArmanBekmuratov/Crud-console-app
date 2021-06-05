package com.arman.crud;

import com.arman.crud.model.Skill;
import com.arman.crud.repo.impl.SkillRepoImpl;

public class Main {
    public static void main(String[] args) {
        SkillRepoImpl skillRepo = new SkillRepoImpl();
        Skill skill = new Skill(1,"speed");
        skillRepo.save(skill);
    }
}
