package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveToFileProduct extends AbstractAction        implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(SaveToFileProduct.class);
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
