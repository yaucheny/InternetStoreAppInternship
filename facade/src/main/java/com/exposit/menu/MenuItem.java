package com.exposit.menu;

import com.exposit.actions.Action;
/**
 * Simple JavaBean object that represents a MenuItem.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class MenuItem {

    private String title;
    private Action action;
    private Menu nextMenu;

    public MenuItem(String title, Action action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public void doAction() {
        action.execute();
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public String getTitle() {
        return title;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
