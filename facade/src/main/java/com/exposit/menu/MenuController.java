package com.exposit.menu;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuController {

    private final Builder builder;
    private Navigator navigator;

    private MenuController(Builder builder) {
        this.builder = builder;
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
            if (index==0) {
                break;
            }
            navigator.navigate(index);
            navigator.printMenu();
        }
    }
}
