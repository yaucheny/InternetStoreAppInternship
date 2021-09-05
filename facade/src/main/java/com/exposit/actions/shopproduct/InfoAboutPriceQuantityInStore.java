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
public class InfoAboutPriceQuantityInStore extends AbstractAction        implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(InfoAboutPriceQuantityInStore.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter store name to get info");
            String storeName = reader.readLine();
            System.out.println(facade.infoAboutPriceQuantityInStore(storeName));
        } catch (Exception e) {
            LOG.error("can not get inf about price and quantity of products in store");
        }
    }
}
