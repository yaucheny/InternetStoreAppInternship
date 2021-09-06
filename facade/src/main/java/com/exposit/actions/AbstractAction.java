package com.exposit.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Abstract class of actions.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class AbstractAction {

    protected BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

}
