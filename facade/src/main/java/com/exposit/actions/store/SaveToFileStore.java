package com.exposit.actions.store;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveToFileStore extends AbstractAction        implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(SaveToFileStore.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            facade.saveStoreToFile();
            System.out.println("stores successfully saved to file");
        } catch (Exception e) {
            LOG.error("can not save to file store");
        }
    }
}
