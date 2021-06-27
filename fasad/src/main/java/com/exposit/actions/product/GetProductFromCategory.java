package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class GetProductFromCategory extends AbstractAction implements IAction {
    @Override
    public void execute() {
        try {
            System.out.println("Choose category one of product:");
            System.out.println("CHILDREN, ADULTS, ANIMALS,FOOD, NON_FOOD,TECHNICS, CLOTHES,  NUTRITION");
            String category = reader.readLine();

            System.out.println(fasade.getProductFromCategory(category));
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
