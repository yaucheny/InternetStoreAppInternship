package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class SortProductByPrice extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println(fasade.sortByPrice());
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
