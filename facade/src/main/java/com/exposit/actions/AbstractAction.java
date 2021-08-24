package com.exposit.actions;

import com.exposit.menu.Fasade;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AbstractAction {

    protected Fasade fasade = new Fasade();
    protected BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

}
