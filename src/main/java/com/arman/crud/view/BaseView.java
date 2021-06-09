package com.arman.crud.view;

import java.util.Scanner;

public abstract class BaseView {
    protected Scanner sc;
    protected String message;

    abstract void save();

    abstract void edit();

    abstract void delete();

    abstract void print();

    void show(){
        boolean isExit = false;
        while (true) {
            print();
            System.out.println("----------------------------------------------");
            System.out.println(message);
            System.out.println("----------------------------------------------");
            String response = sc.next();
            switch (response) {
                case "1":
                    save();
                    break;
                case "2":
                    edit();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    print();
                    break;
                case "5":
                    isExit = true;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

            if (isExit)
                break;
        }
    }
}
