package com.exposit.actions.orderitem;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveToFileOrderItem extends AbstractAction        implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(SaveToFileOrderItem.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            facade.saveOrderItemToFile();
            System.out.println("orderItems successfully saved to file");
        } catch (Exception e) {
            LOG.error("can not save to file orderItem");
        }
    }
}
