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
public class DeleteCategory extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteCategory.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of category to be deleted");
            Long categoryId = Long.parseLong(reader.readLine());
            facade.deleteCategory(categoryId);
            System.out.println("category id :" + categoryId + " deleted");
        } catch (Exception e) {
            LOG.error("can not delete category");
        }
    }
}
