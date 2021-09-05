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
public class GetByIdCustomer   extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(GetByIdCustomer.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of customer");
            Long customerId = Long.parseLong(reader.readLine());
            System.out.println(facade.getCustomerById(customerId));
        } catch (Exception e) {
            LOG.error("can not get by id customer");
        }
    }
}
