package com.arman.crud.controller;
import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;
import com.arman.crud.service.DeveloperService;
import java.util.List;


public class DeveloperController {
    DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public DeveloperController() {
    }

    public List<Developer> getAll() {
        return developerService.getAll();
    }

    public Developer getById(Integer id)  {
        return developerService.getById(id);
    }

    public Developer save(String firstName, String lastName) {
        return developerService.save(firstName, lastName);
    }

    public void update(Integer id, String firstName, String lastName) {
        developerService.update(id, firstName, lastName);
    }

    public void deleteById(Integer id)  {
        developerService.deleteById(id);
    }
}
