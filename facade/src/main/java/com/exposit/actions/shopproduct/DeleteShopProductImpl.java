package com.exposit.actions.shopproduct;

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
public class DeleteShopProductImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteShopProductImpl.class);
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
