package com.arman.crud.view;

import com.arman.crud.controller.SkillController;
import com.arman.crud.controller.TeamController;
import com.arman.crud.model.Skill;
import com.arman.crud.model.Team;

import java.util.List;
import java.util.Scanner;

public class TeamView extends BaseView{
    private TeamController teamController;


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

    public TeamView(TeamController teamController, Scanner sc) {
        this.teamController = teamController;
        this.sc = sc;
        this.message = mainMenuMessage;
    }

    @Override
    public void save() {
        System.out.println("---------------------------");
        System.out.println(createMenuMessage);
        String name = sc.next();
        try {
            teamController.save(name);
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
            teamController.update(id, name);
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
            teamController.deleteById(id);
            System.out.println("Успешная операция");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка");
        }

        System.out.println("---------------------------");
    }

    @Override
    public void print() {
        List<Team> teamList;
        try {
            teamList = teamController.getAll();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(teamList);;
        System.out.println("---------------------------");
        System.out.println(printMenuMessage);
        if (teamList.size() != 0) {
            for (Team t : teamList) {
                System.out.println(t.getId() + "; " + t.getName());
            }
        } else {
            System.out.println("Список пуст");
        }
        System.out.println("---------------------------");
    }
}
