package com.exposit.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Special class that connects every point of menu to the method invocation.
 * This class is responsible for navigation by menu.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class Navigator {

    private static final Logger LOG = LoggerFactory.getLogger(Navigator.class);
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
            LOG.warn("Wrong index was selected", e);

        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
