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
public class GetByIdOrderItem extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(GetByIdOrderItem.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of orderItem");
            Long orderItemId = Long.parseLong(reader.readLine());
            System.out.println(facade.getOrderItemById(orderItemId));
        } catch (Exception e) {
            LOG.error("can not get by id orderItem");
        }
    }
}
