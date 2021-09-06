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
public class SaveToFileCustomerImpl extends AbstractAction        implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(SaveToFileCustomerImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            facade.saveCustomerToFile();
            System.out.println("customers successfully saved to file");
        } catch (Exception e) {
            LOG.error("can not save to file customer");
        }
    }
}
