package com.exposit.menu;

import com.exposit.actions.IAction;

public class MenuItem {

    private String title;
    private IAction action;
    private Menu nextMenu;

    public MenuItem(String title, IAction action, Menu nextMenu) {
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

    public void setAction(IAction action) {
        this.action = action;
    }
}
