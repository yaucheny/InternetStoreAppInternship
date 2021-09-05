package com.exposit.actions.customer;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.domain.dto.CustomerDto;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomer extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateCustomer.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of customer to be updated");
            Long customerId = Long.parseLong(reader.readLine());
            System.out.println("Enter new firstName of customer");
            String firstName = reader.readLine();
            System.out.println("Enter new secondName of customer");
            String lastName = reader.readLine();
            System.out.println("Enter new address of customer");
            String customerAddress = reader.readLine();
            System.out.println("Enter new email of customer");
            String customerEmail = reader.readLine();
            CustomerDto customerDto = new CustomerDto();
            customerDto.setAddress(customerAddress);
            customerDto.setFirstName(firstName);
            customerDto.setLastName(lastName);
            customerDto.setEmail(customerEmail);
            facade.updateCustomer(customerId, customerDto);
            System.out.println("customer id :" + customerId + " updated");
        } catch (Exception e) {
            LOG.error("can not update customer");
        }
    }
}
