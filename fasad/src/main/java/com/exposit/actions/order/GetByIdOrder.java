package com.exposit.actions.order;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class GetByIdOrder  extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println("Enter id of order");
            Long orderId = Long.parseLong(reader.readLine());

            System.out.println(fasade.getOrderById(orderId));
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
