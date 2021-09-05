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
public class DeleteOrderItem extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteOrderItem.class);
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
