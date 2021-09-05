package com.exposit.actions.category;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdCategory extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(GetByIdCategory.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of category");
            Long categoryId = Long.parseLong(reader.readLine());
            System.out.println(facade.getCustomerById(categoryId));
        } catch (Exception e) {
            LOG.error("can not get by id category");
        }
    }
}
