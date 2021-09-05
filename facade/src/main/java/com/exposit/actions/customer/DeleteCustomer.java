package com.exposit.actions.customer;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomer extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteCustomer.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of order to be deleted");
            Long customerId = Long.parseLong(reader.readLine());
            facade.deleteCustomer(customerId);
            System.out.println("customer id :" + customerId + " deleted");
        } catch (Exception e) {
            LOG.error("can not delete customer");
        }
    }
}
