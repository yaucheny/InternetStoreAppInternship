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
public class GetShopProductFromCategory extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(GetShopProductFromCategory.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter category of product:");
            String category = reader.readLine();

            System.out.println(facade.getGoodsFromCategory(category));
        } catch (Exception e) {
            LOG.error("can not get shop product by category");
        }
    }
}
