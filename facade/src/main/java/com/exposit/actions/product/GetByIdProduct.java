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
public class GetByIdProduct extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(GetByIdProduct.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of product");
            Long productId = Long.parseLong(reader.readLine());
            System.out.println(facade.getProductById(productId));
        } catch (Exception e) {
            LOG.error("can not get by id product");
        }
    }
}
