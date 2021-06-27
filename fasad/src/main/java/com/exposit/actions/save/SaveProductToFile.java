package com.exposit.actions.save;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class SaveProductToFile extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            fasade.saveAllProductsToFile();
            System.out.println("Products successfully saved to file");

        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
