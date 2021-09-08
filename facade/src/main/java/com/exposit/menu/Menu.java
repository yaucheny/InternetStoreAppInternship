package com.exposit.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple JavaBean object that represents a Menu.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class Menu {

    private List<MenuItem> menuItems = new ArrayList<>();

    public List<MenuItem> getMenuItems() {

        return menuItems;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }
}
