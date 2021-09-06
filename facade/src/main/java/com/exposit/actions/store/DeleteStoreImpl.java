package com.exposit.actions.store;

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
public class DeleteStoreImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteStoreImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of store to be deleted");
            Long storeId = Long.parseLong(reader.readLine());
            facade.deleteStore(storeId);
            System.out.println("store id :" + storeId + " deleted");
        } catch (Exception e) {
            LOG.error("can not delete store");
        }
    }
}
