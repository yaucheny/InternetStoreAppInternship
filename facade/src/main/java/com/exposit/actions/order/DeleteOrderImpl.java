package com.exposit.actions.order;

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
public class DeleteOrderImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteOrderImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of order to be deleted");
            Long orderId = Long.parseLong(reader.readLine());
            facade.deleteOrder(orderId);
            System.out.println("order id :" + orderId + " deleted");
        } catch (Exception e) {
            LOG.error("can not delete order");
        }
    }
}
