package com.exposit.actions;

import com.exposit.menu.Fasade;
import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Log4j
public class AbstractAction {

    protected Fasade fasade = new Fasade();
    protected BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

}
