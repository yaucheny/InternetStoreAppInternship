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
public class GetByIdOrderItemImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(GetByIdOrderItemImpl.class);
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
