package com.arman.crud.view;

import com.arman.crud.controller.DeveloperController;
import com.arman.crud.controller.SkillController;
import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;
import com.arman.crud.repo.SkillRepo;
import com.arman.crud.repo.impl.SkillRepoImpl;
import scala.concurrent.impl.FutureConvertersImpl;

import javax.management.openmbean.CompositeData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperView extends BaseView{

    private DeveloperController developerController;
    private SkillController skillController;

    private final String mainMenuMessage = "Выберете действие над разработчиком:\n" +
            " 1. Создать\n" +
            " 2. Редактировать\n" +
            " 3. Удалить\n" +
            " 4. Вывести список\n" +
            " 5. Выход";

    private final String printMenuMessage = "Список разработчиков:\n" +
            "ID; имя; фамилия; список навыков";

    private final String createMenuMessage = "Добавление разрабротчика.\n" +
            "Введите имя, фамилию и список навыков";

    private final String editMenuMessage = "Редактирование разработчика.\n" +
            "Введите ID";

    private final String deleteMenuMessage = "Удаление разработчика\n" +
            "Введите ID";



    @Override
    void save() {
        System.out.println("---------------------------");
        System.out.println(createMenuMessage);
        String firstName = sc.next();
        String lastName = sc.next();
        try {
            developerController.save(firstName, lastName);
            System.out.println("Successful operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
        System.out.println("---------------------------");
    }

    @Override
    void edit() {
        System.out.println("---------------------------");
        System.out.println(editMenuMessage);
        Integer id = sc.nextInt();
        System.out.println("---------------------------");
        String firstName = sc.next();
        String lastName = sc.next();
        SkillRepoImpl skillRepo = new SkillRepoImpl();
        List<Skill> skillList =  skillRepo.readFile();
        for(Skill s : skillList) {
            System.out.println(s.getId() + ": " + s.getName());
        }
        try {
            developerController.update(id, firstName, lastName, skillList);
            System.out.println("Успешная операция");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка!");
        }
        System.out.println("---------------------------");
    }

    @Override
    void delete() {
        System.out.println("---------------------------");
        System.out.println(deleteMenuMessage);
        Integer id = sc.nextInt();
        try {
            developerController.deleteById(id);
            System.out.println("Успешная операция");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка");
        }

        System.out.println("---------------------------");
    }

    @Override
    void print() {
        List<Developer> developerList;
        try {
            developerList = developerController.getAll();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(developerList);;
        System.out.println("---------------------------");
        System.out.println(printMenuMessage);
        if (developerList.size() != 0) {
            for (Developer d : developerList) {
                System.out.println(d.getId() + "; " + d.getFirstName() + " "
                            +  d.getLastName());
            }
        } else {
            System.out.println("Список пуст");
        }
        System.out.println("---------------------------");
    }
}
