package com.arman.crud.view;

import com.arman.crud.controller.SkillController;
import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SkillView extends BaseView{

    private  SkillController skillController;


    private final String mainMenuMessage = "Выберете действие над навыками разработчика:\n" +
            " 1. Создать\n" +
            " 2. Редактировать\n" +
            " 3. Удалить\n" +
            " 4. Вывести список\n" +
            " 5. Выход";

    private final String printMenuMessage = "Список навыков:\n" +
            "ID; название";

    private final String createMenuMessage = "Создание навыка.\n" +
            "Введите название";

    private final String editMenuMessage = "Редактирование навыка.\n" +
            "Введите ID";

    private final String deleteMenuMessage = "Удаление навыка\n" +
            "Введите ID";

    public SkillView(SkillController skillController, Scanner sc) {
        this.skillController = skillController;
        this.sc = sc;
        this.message = mainMenuMessage;
    }

    @Override
    public void save() {
        System.out.println("---------------------------");
        System.out.println(createMenuMessage);
        String name = sc.next();
        try {
            skillController.save(name);
            System.out.println("Successful operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
        System.out.println("---------------------------");
    }

    @Override
    public void edit() {
        System.out.println("---------------------------");
        System.out.println(editMenuMessage);
        Integer id = sc.nextInt();
        System.out.println("---------------------------");
        String name = sc.next();
        try {
            skillController.update(id, name);
            System.out.println("Успешная операция");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка!");
        }
        System.out.println("---------------------------");
    }

    @Override
    public void delete() {
        System.out.println("---------------------------");
        System.out.println(deleteMenuMessage);
        Integer id = sc.nextInt();
        try {
            skillController.deleteById(id);
            System.out.println("Успешная операция");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка");
        }

        System.out.println("---------------------------");
    }

    @Override
    public void print() {
        List<Skill> skillList;
        try {
            skillList = skillController.getAll();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
        skillList.sort(Comparator.comparing(Skill::getId));
        System.out.println(skillList);;
        System.out.println("---------------------------");
        System.out.println(printMenuMessage);
        if (skillList.size() != 0) {
            for (Skill s : skillList) {
                System.out.println(s.getId() + "; " + s.getName());
            }
        } else {
            System.out.println("Список пуст");
        }
        System.out.println("---------------------------");
    }
}
