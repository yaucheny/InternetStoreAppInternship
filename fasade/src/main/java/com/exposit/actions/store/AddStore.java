package com.exposit.actions.store;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class AddStore extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {

            System.out.println("Enter name of store");
            String storeName = reader.readLine();
            System.out.println("Enter internet page of store");
            String internetPage = reader.readLine();
            System.out.println("Enter phone number of store");
            String phoneNumber = reader.readLine();
            fasade.addStore(storeName, internetPage, phoneNumber);
            System.out.println("store successfully created");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
