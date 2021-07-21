package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class DeleteProduct extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println("Enter id of product to be deleted");
            Long productId = Long.parseLong(reader.readLine());
            fasade.deleteProduct(productId);
            System.out.println("product id :" + productId + " deleted");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
