package com.exposit.actions.save;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class SaveCustomerToFile extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
        fasade.saveAllCustomersToFile();
            System.out.println("Customers successfully saved to file");

        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
