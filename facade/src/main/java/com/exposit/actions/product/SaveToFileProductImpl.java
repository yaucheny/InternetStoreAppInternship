package com.exposit.actions.product;

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
public class SaveToFileProductImpl extends AbstractAction        implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(SaveToFileProductImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            facade.saveProductToFile();
            System.out.println("products successfully saved to file");
        } catch (Exception e) {
            LOG.error("can not save to file product");
        }
    }
}
