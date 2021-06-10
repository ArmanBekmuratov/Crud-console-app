package com.arman.crud.view;

import com.arman.crud.controller.DeveloperController;
import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;

import java.util.List;
import java.util.Scanner;

public class DeveloperView extends BaseView{

    private DeveloperController developerController;

    private final String mainMenuMessage = "Выберете действие над разработчиком:\n" +
            " 1. Создать\n" +
            " 2. Редактировать\n" +
            " 3. Удалить\n" +
            " 4. Вывести список\n" +
            " 5. Выход";

    private final String printMenuMessage = "Список разработчиков:\n" +
            "ID; название";

    private final String createMenuMessage = "Добавление разработчика.\n" +
            "Введите имя и фамилию";

    private final String editMenuMessage = "Изменение разработчика.\n" +
            "Введите ID";

    private final String deleteMenuMessage = "Удаление разработчика\n" +
            "Введите ID";

    public DeveloperView(DeveloperController developerController, Scanner sc) {
        this.developerController = developerController;
        this.sc = sc;
        this.message = mainMenuMessage;
    }

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
        try {
            developerController.update(id, firstName, lastName);
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
        if (developerList != null) {
            for (Developer d : developerList) {
                System.out.println(d.getId() + "; " + d.getFirstName() + "; " + d.getLastName());
            }
        } else {
            System.out.println("Список пуст");
        }
        System.out.println("---------------------------");
    }
}
