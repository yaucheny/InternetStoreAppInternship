package com.exposit.actions.save;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class SaveOrderToFile extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            fasade.saveAllOrdersToFile();
            System.out.println("Orders successfully saved to file");

        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
