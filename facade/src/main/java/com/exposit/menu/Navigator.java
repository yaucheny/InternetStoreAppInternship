package com.exposit.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Navigator {

    private final static Logger log = LoggerFactory.getLogger(Navigator.class);
    private MenuItem menuItem;
    private static Navigator instance;
    private Menu currentMenu;

    private Navigator() {

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
            log.warn("Wrong index was selected", e);

        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}