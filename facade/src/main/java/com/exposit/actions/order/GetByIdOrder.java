package com.exposit.actions.order;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdOrder  extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(GetByIdOrder.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of order");
            Long orderId = Long.parseLong(reader.readLine());
            System.out.println(facade.getOrderById(orderId));
        } catch (Exception e) {
            LOG.error("can not get by id order");
        }
    }
}
