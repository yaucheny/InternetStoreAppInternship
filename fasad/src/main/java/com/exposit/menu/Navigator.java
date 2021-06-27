package com.exposit.menu;


import lombok.extern.log4j.Log4j;

import java.util.Objects;

@Log4j
public class Navigator {
    private MenuItem menuItem;
    private static Navigator instance;
    private Menu currentMenu;

    public Navigator() {

    }

    public static Navigator getInstance() {
        return Objects.requireNonNullElse(instance, new Navigator());
    }

    public void printMenu() {

        if (!currentMenu.getMenuItems().isEmpty()) {
            int pos = -1;
            for (MenuItem item : currentMenu.getMenuItems()) {
                pos++;
                if (item != null) {
                    System.out.println(pos + "-" + item.getTitle());
                }
            }
        }
        System.out.println("choose index");

    }

    public void navigate(int index) {
        try {
            if (currentMenu != null) {
                MenuItem menuItem = currentMenu.getMenuItems().get(index);
                menuItem.doAction();
                currentMenu = menuItem.getNextMenu();

            }
        } catch (IndexOutOfBoundsException e) {
            log.warn( "Wrong index was selected", e);

        }
    }


    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}