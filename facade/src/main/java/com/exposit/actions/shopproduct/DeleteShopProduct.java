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
public class DeleteShopProduct extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteShopProduct.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of shopProduct to be deleted");
            Long shopProductId = Long.parseLong(reader.readLine());
            facade.deleteShopProduct(shopProductId);
            System.out.println("shopProduct id :" + shopProductId + " deleted");
        } catch (Exception e) {
            LOG.error("can not delete shopProduct");
        }
    }
}
