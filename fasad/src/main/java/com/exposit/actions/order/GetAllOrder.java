package com.exposit.actions.order;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class GetAllOrder  extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println(fasade.getAllOrder());
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
