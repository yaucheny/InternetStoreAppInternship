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
public class FindShopProductByOneAttributeImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(FindShopProductByOneAttributeImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Choose attribute of product from: ");
            System.out.println("productName, productProducer, productPrice,productQuantity, storeName");
            String attribute = reader.readLine();
            System.out.println("Enter value of attribute of product");
            String value = reader.readLine();
            System.out.println(facade.findByOneAttribute(value, attribute));
        } catch (Exception e) {
            LOG.error("can not find shop product by one attribute");
        }
    }
}
