package com.exposit.actions;

import com.exposit.menu.Facade;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AbstractAction {

    protected Facade facade = new Facade();
    protected BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

}
