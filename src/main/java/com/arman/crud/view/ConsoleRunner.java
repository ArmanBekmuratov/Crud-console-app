package com.arman.crud.view;

import com.arman.crud.controller.DeveloperController;
import com.arman.crud.controller.SkillController;
import com.arman.crud.repo.DeveloperRepo;
import com.arman.crud.repo.SkillRepo;
import com.arman.crud.repo.impl.DeveloperRepoImpl;
import com.arman.crud.repo.impl.SkillRepoImpl;
import com.arman.crud.service.DeveloperService;
import com.arman.crud.service.SkillService;
import com.arman.crud.service.impl.DeveloperServiceImpl;
import com.arman.crud.service.impl.SkillServiceImpl;
import java.util.Scanner;

public class ConsoleRunner {

    BaseView skillView;
    BaseView developerView;


    private final String damagedDataMessage = "Данные повреждены!";

    private final String menuMessage = "Выберете действие:\n" +
            "1. Разработчик\n" +
            "2. Навыки\n" +
            "3. Команды\n" +
            "4. Выход";


    private Scanner sc = new Scanner(System.in);

    public ConsoleRunner(){
        try {
            //create repo
            SkillRepo skillRepo = new SkillRepoImpl();
            DeveloperRepo developerRepo = new DeveloperRepoImpl();

            //create services
            SkillService skillService = new SkillServiceImpl(skillRepo);
            DeveloperService developerService = new DeveloperServiceImpl(developerRepo);

            //create controllers
            SkillController skillController = new SkillController(skillService);
            DeveloperController developerController = new DeveloperController(developerService);


            //create views
            skillView = new SkillView(skillController, sc);
            developerView = new DeveloperView(developerController, sc);

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
                case "1":
                    developerView.show();
                    break;
                case "2":
                    skillView.show();
                    break;
                /*case "3":
                    teamView.show();*/
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

