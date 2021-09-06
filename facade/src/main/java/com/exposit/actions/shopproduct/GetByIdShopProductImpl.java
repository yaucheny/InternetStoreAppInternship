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
public class GetByIdShopProductImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(GetByIdShopProductImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of shopProduct");
            Long shopProductId = Long.parseLong(reader.readLine());
            System.out.println(facade.getShopProductById(shopProductId));
        } catch (Exception e) {
            LOG.error("can not get by id shopProduct");
        }
    }
}

