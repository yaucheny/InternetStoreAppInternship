package com.exposit.actions.category;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.Action;
import com.exposit.domain.dto.CategoryDto;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementation of {@link Action} interface.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class AddCategoryImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(AddCategoryImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter name");
            String name = reader.readLine();
            System.out.println("Enter parent id of category");
            Long parentId = Long.parseLong(reader.readLine());
            List<CategoryDb> categoryDbList = List.of();
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(name);
            categoryDto.setParentId(parentId);
            categoryDto.setChildList(categoryDbList);
            facade.addCategory(categoryDto);
            System.out.println("category successfully created");
        } catch (Exception e) {
            LOG.error("can not create category");
        }
    }
}
