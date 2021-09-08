package com.exposit.actions.orderitem;

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
public class DeleteOrderItemImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteOrderItemImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of orderItem to be deleted");
            Long orderItemId = Long.parseLong(reader.readLine());
            facade.deleteOrderItem(orderItemId);
            System.out.println("orderItem id :" + orderItemId + " deleted");
        } catch (Exception e) {
            LOG.error("can not delete orderItem");
        }
    }
}
