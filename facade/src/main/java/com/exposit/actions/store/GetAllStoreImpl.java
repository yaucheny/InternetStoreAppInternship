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
public class GetAllStoreImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(GetAllStoreImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println(facade.getAllStore());
        } catch (Exception e) {
            LOG.error("can not get all store");
        }
    }
}
