package com.exposit.actions.store;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class UpdateStore extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println("Enter id of store to be updated");
            Long storeId = Long.parseLong(reader.readLine());
            System.out.println("Enter new name of store");
            String storeName = reader.readLine();
            System.out.println("Enter new internet page of store");
            String internetPage = reader.readLine();
            System.out.println("Enter new phone number of store");
            String phoneNumber = reader.readLine();
            fasade.updateStore(storeId, storeName, internetPage, phoneNumber);
            System.out.println("store id :" + storeId + " updated");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
