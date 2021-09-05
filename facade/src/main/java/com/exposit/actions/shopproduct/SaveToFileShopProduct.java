package com.exposit.actions.shopproduct;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveToFileShopProduct extends AbstractAction        implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(SaveToFileShopProduct.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            facade.saveShopProductToFile();
            System.out.println("shopProducts successfully saved to file");
        } catch (Exception e) {
            LOG.error("can not save to file shopProduct");
        }
    }
}
