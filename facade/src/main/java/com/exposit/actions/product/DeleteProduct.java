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
public class DeleteProduct extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteProduct.class);
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
