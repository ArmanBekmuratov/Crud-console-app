package com.arman.crud.service;

import com.arman.crud.model.Skill;
import com.arman.crud.model.Team;

public interface TeamService extends GenericService<Team>{
    Team save(String name);

    Team update(Integer id,String name);
}
