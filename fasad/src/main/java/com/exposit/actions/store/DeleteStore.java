package com.exposit.actions.store;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class DeleteStore  extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println("Enter id of store to be deleted");
            Long storeId = Long.parseLong(reader.readLine());
            fasade.deleteStore(storeId);
            System.out.println("store id :" + storeId+" deleted");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
