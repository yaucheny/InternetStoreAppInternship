package com.exposit.actions.category;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.domain.dto.CategoryDto;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateCategory extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateCategory.class);
    private final Facade facade;

    @Override
    public void execute() {

        try {
            System.out.println("Enter id of category to be updated");
            Long categoryId = Long.parseLong(reader.readLine());
            System.out.println("Enter name");
            String name = reader.readLine();
            System.out.println("Enter parent id of category");
            Long parentId = Long.parseLong(reader.readLine());
            List<CategoryDb> categoryDbList = List.of();
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(name);
            categoryDto.setParentId(parentId);
            categoryDto.setChildList(categoryDbList);
            facade.updateCategory(categoryId, categoryDto);
            System.out.println("category id :" + categoryId + " updated");
        } catch (Exception e) {
            LOG.error("can not update category");
        }
    }
}
