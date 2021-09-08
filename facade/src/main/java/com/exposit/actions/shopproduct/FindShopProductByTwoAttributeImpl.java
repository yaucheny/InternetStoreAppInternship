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
public class FindShopProductByTwoAttributeImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(FindShopProductByTwoAttributeImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Choose attribute one of product from: ");
            System.out.println("productName, productProducer, productPrice,productQuantity, storeName");
            String attribute1 = reader.readLine();
            System.out.println("Enter value one of attribute one of product");
            String value1 = reader.readLine();
            System.out.println("Choose attribute two of product from: ");
            System.out.println("productName, productProducer, productPrice, productQuantity, storeName");
            String attribute2 = reader.readLine();
            System.out.println("Enter value two of attribute two of product");
            String value2 = reader.readLine();
            System.out.println(facade.findByTwoAttribute(value1, attribute1, value2, attribute2));
        } catch (Exception e) {
            LOG.error("can not find shop product by two attributes");
        }
    }
}
