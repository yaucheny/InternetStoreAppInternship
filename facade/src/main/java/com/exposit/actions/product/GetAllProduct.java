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
public class GetAllProduct extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(GetAllProduct.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println(facade.getAllProduct());
        } catch (Exception e) {
            LOG.error("can not get all products");
        }
    }
}
