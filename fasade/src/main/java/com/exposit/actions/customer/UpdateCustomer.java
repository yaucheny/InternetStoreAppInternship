package com.exposit.actions.customer;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class UpdateCustomer extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println("Enter id of customer to be updated");
            Long customerId = Long.parseLong(reader.readLine());
            System.out.println("Enter new firstName of customer");
            String firstName = reader.readLine();
            System.out.println("Enter new secondName of customer");
            String lastName = reader.readLine();
            System.out.println("Enter new adress of customer");
            String customerAdress = reader.readLine();
            System.out.println("Enter new email of customer");
            String customerEmail = reader.readLine();
            fasade.updateCustomer(customerId, firstName, lastName,
                    customerAdress, customerEmail);
            System.out.println("customer id :" + customerId + " updated");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
