package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class GetAllProduct extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println(fasade.getAllProduct());
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
