package com.exposit.actions.category;

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
public class DeleteCategoryImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryImpl.class);
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
