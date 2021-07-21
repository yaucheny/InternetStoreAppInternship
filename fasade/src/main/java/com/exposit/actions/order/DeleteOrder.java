package com.exposit.actions.order;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class DeleteOrder extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println("Enter id of order to be deleted");
            Long orderId = Long.parseLong(reader.readLine());
            fasade.deleteOrder(orderId);
            System.out.println("order id :" + orderId + " deleted");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
