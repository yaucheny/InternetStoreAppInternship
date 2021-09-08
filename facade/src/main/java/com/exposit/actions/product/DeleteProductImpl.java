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
public class DeleteProductImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteProductImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of product to be deleted");
            Long productId = Long.parseLong(reader.readLine());
            facade.deleteProduct(productId);
            System.out.println("product id :" + productId + " deleted");
        } catch (Exception e) {
            LOG.error("can not delete product");
        }
    }
}
