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

    public MenuItem(String title1, Action action1, Menu nextMenu1) {
        this.title = title1;
        this.action = action1;
        this.nextMenu = nextMenu1;
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

    public void setAction(Action action1) {
        this.action = action1;
    }
}
