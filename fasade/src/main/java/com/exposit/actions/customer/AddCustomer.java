package com.exposit.actions.customer;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class AddCustomer extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {

            System.out.println("Enter firstName of customer");
            String firstName = reader.readLine();
            System.out.println("Enter secondName of customer");
            String lastName = reader.readLine();
            System.out.println("Enter address of customer");
            String customerAdress = reader.readLine();
            System.out.println("Enter email of customer");
            String customerEmail = reader.readLine();
            fasade.addCustomer(firstName, lastName,
                    customerAdress, customerEmail);
            System.out.println("customer successfully created");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
