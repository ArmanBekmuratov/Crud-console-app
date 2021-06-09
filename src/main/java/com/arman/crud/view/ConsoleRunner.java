package com.arman.crud.view;

import com.arman.crud.controller.SkillController;
import com.arman.crud.repo.SkillRepo;
import com.arman.crud.repo.impl.SkillRepoImpl;
import com.arman.crud.service.SkillService;
import com.arman.crud.service.impl.SkillServiceImpl;

import java.util.Scanner;

public class ConsoleRunner {

    BaseView skillView;

    private final String damagedDataMessage = "Данные повреждены!";

    private final String menuMessage = "Выберете действие:\n" +
            "1. Категории\n" +
            "2. Навыки\n" +
            "3. Проекты\n" +
            "4. Выход";


    private Scanner sc = new Scanner(System.in);

    public ConsoleRunner(){
        try {
            //create repo
            SkillRepo customerRepo = new SkillRepoImpl();


            //create services
            SkillService skillService = new SkillServiceImpl(customerRepo);


            //create controllers
            SkillController skillController = new SkillController(skillService);

            //create views
            skillView = new SkillView(skillController, sc);

        }
        catch (Exception ex)
        {
            System.out.println(damagedDataMessage);
        }
    }

    public void run()  {
        boolean isExit = false;
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println(menuMessage);
            System.out.println("----------------------------------------------");
            String response = sc.next();
            switch (response)
            {
                case "2":
                    skillView.show();
                    break;

                case "4":
                    isExit = true;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            if (isExit)
                break;
        }
        sc.close();
    }
}

