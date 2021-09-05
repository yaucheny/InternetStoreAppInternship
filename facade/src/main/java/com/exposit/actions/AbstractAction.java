package com.exposit.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AbstractAction {

    protected BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

}
