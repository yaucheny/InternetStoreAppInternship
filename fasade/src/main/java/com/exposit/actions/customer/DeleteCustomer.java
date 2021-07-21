package com.exposit.actions.customer;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class DeleteCustomer extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println("Enter id of order to be deleted");
            Long customerId = Long.parseLong(reader.readLine());
            fasade.deleteCustomer(customerId);
            System.out.println("customer id :" + customerId + " deleted");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
