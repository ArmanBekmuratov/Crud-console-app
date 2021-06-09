package com.arman.crud.service;

import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;

import javax.swing.plaf.SliderUI;
import java.util.List;


public interface DeveloperService extends GenericService<Developer>{
    Developer save(String firstName, String lastName);

    Developer update(Integer id,String firstName, String lastName, List<Skill> skillList);
}
