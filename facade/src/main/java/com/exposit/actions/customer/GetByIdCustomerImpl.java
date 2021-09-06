package com.exposit.actions.customer;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.Action;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * Implementation of {@link Action} interface.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class GetByIdCustomerImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(GetByIdCustomerImpl.class);
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
