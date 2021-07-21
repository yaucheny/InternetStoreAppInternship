package com.exposit.actions.save.saveToJson;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class SaveOrderToFileJson extends AbstractAction implements IAction {
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
