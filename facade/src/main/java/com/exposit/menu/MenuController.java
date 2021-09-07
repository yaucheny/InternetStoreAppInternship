package com.exposit.menu;

import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Special class controls actions of console menu.
 * This class is responsible for running in main menu and calling additional menu items.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Component
public class MenuController {

    private final Builder builder;
    private Navigator navigator;

    public MenuController(Builder builder1) {
        this.builder = builder1;
        this.builder.buildMenu();
        navigator = Navigator.getInstance();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        int index = 1;
        while (index > 0) {

            index = scanner.nextInt();
            if (index == 0) {
                break;
            }
            navigator.navigate(index);
            navigator.printMenu();
        }
    }
}
