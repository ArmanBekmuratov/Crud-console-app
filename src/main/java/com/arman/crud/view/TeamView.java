package com.arman.crud.view;
import com.arman.crud.controller.TeamController;
import com.arman.crud.model.Developer;
import com.arman.crud.model.Team;
import com.arman.crud.model.TeamStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class TeamView extends BaseView{
    private final TeamController teamController;


    private final String mainMenuMessage = "Выберете действие над командами разработчиков:\n" +
            " 1. Создать\n" +
            " 2. Редактировать\n" +
            " 3. Удалить\n" +
            " 4. Вывести список\n" +
            " 5. Выход";

    private final String printMenuMessage = "Список команд:\n" +
            "ID; название";

    private final String createMenuMessage = "Создание команды.\n" +
            "Введите название";

    private final String editMenuMessage = "Редактирование команды.\n" +
            "Введите ID";

    private final String deleteMenuMessage = "Удаление команды\n" +
            "Введите ID";
    private final String answerYes = "y";

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
        List<Integer> developerIds = chooseDevelopers();
        try {
            teamController.save(name, developerIds, TeamStatus.ACTIVE);
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
        List<Integer> developerIds = chooseDevelopers();
        try {
            teamController.update(id, name, developerIds,TeamStatus.ACTIVE);
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
        System.out.println(teamList);
        System.out.println("---------------------------");
        System.out.println(printMenuMessage);
        if (teamList != null) {
            for (Team t : teamList) {
                String printLine = t.getId() + "; " + t.getName() + "; "
                         + t.getDevelopers() ;
                StringJoiner joiner = new StringJoiner("/");
                for (Developer d : t.getDevelopers()
                ) {
                    joiner.add(d.getFirstName());
                    joiner.add(d.getLastName());
                }
                printLine += joiner.toString();
                System.out.println(printLine);
            }
        } else {
            System.out.println("Список пуст");
        }
        System.out.println("---------------------------");
    }

    private List<Integer> chooseDevelopers() {
        List<Integer> developersIds = new ArrayList<>();
        while(true) {
            System.out.println("---------------------------");
            System.out.println("Введите ID разработчика ");
            Integer skillId = sc.nextInt();
            developersIds.add(skillId);
            System.out.println("Хотите ли добавить еще разработчика в команду? y/n");
            String response = sc.next();
            if (!response.equalsIgnoreCase(answerYes)) {
                break;
            }
            System.out.println("---------------------------");
        }
        return developersIds;
    }
}
