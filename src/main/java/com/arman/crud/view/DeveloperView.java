package com.arman.crud.view;

import com.arman.crud.controller.DeveloperController;
import com.arman.crud.controller.SkillController;
import com.arman.crud.model.Developer;
import com.arman.crud.model.Skill;

import java.util.*;

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
            "ID; Имя; Фамилия";

    private final String createMenuMessage = "Добавление разработчика.\n" +
            "Введите имя и фамилию";

    private final String editMenuMessage = "Изменение разработчика.\n" +
            "Введите ID";

    private final String deleteMenuMessage = "Удаление разработчика\n" +
            "Введите ID";

    private final String answerYes = "y";

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
        List<Integer> skillIds = chooseSkills();
        try {
            developerController.save(firstName, lastName,skillIds);
            System.out.println("Successful operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Create Error");
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
        List<Integer> skillIds = chooseSkills();
        try {
            developerController.update(id, firstName, lastName, skillIds);
            System.out.println("Successful operation");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Edit Error");
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

    private List<Integer> chooseSkills() {
        List<Integer> skillIds = new ArrayList<>();
        while(true) {
            System.out.println("---------------------------");
            System.out.println("Введите ID навыка ");
            Integer skillId = sc.nextInt();
            skillIds.add(skillId);
            System.out.println("Хотите ли добавить еще навык? y/n");
            String response = sc.next();
            if (!response.equalsIgnoreCase(answerYes)) {
                break;
            }
            System.out.println("---------------------------");
        }
        return skillIds;
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
       developerList.sort(Comparator.comparing(Developer::getId));
        System.out.println(developerList);
        System.out.println("---------------------------");
        System.out.println(printMenuMessage);

        for (Developer d : developerList) {

            String printLine = d.getId() + "; " + d.getFirstName() + "; "
                    + d.getLastName()  + "; " ;
            StringJoiner joiner = new StringJoiner("/");
            printLine += joiner.toString();
            System.out.println(printLine);
        }
        System.out.println("---------------------------");
    }
}
