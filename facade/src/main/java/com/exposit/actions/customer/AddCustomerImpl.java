package com.exposit.actions.customer;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.Action;
import com.exposit.domain.dto.CustomerDto;
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
public class AddCustomerImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(AddCustomerImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter firstName of customer");
            String firstName = reader.readLine();
            System.out.println("Enter secondName of customer");
            String lastName = reader.readLine();
            System.out.println("Enter address of customer");
            String customerAddress = reader.readLine();
            System.out.println("Enter email of customer");
            String customerEmail = reader.readLine();
            CustomerDto customerDto = new CustomerDto();
            customerDto.setAddress(customerAddress);
            customerDto.setFirstName(firstName);
            customerDto.setLastName(lastName);
            customerDto.setEmail(customerEmail);
            facade.addCustomer(customerDto);
            System.out.println("customer successfully created");
        } catch (Exception e) {
            LOG.error("can not create customer");
        }
    }
}
