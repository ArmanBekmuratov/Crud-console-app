package com.arman.crud.service;

import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;
import java.util.List;


public interface DeveloperService extends GenericService<Developer>{
    Developer save(String firstName, String lastName, List<Integer> skillIds);

    Developer update(Integer id,String firstName, String lastName, List<Integer> skillIds);
}
