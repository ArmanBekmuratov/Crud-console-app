package com.arman.crud.controller;
import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;
import com.arman.crud.service.DeveloperService;
import com.arman.crud.service.impl.DeveloperServiceImpl;

import java.util.List;


public class DeveloperController {
    DeveloperService developerService = new DeveloperServiceImpl();


    public DeveloperController() {
    }

    public List<Developer> getAll() {
        return developerService.getAll();
    }

    public Developer getById(Integer id)  {
        return developerService.getById(id);
    }

    public Developer save(String firstName, String lastName,List<Integer> skillIds) {
        return developerService.save(firstName, lastName,skillIds);
    }

    public Developer update(Integer id, String firstName, String lastName, List<Integer> skillIds) {
        return developerService.update(id, firstName, lastName, skillIds);
    }

    public void deleteById(Integer id)  {
        developerService.deleteById(id);
    }

}
