package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.Action;
import com.exposit.api.dao.CategoryDao;
import com.exposit.domain.dto.ProductDto;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link Action} interface.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class AddProductImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(AddProductImpl.class);
    private final Facade facade;
    private final CategoryDao categoryDao;

    @Override
    public void execute() {
        try {
            System.out.println("Enter name of product");
            String name = reader.readLine();
            System.out.println("Enter id of producer of product");
            String producer = reader.readLine();
            System.out.println("Enter id of categories of product");
            System.out.println("to escape entering enter 0");
            List<CategoryDb> categoryDbList = new ArrayList<>();
            while (!"0".equals(reader.readLine())) {
                Long categoryId = Long.parseLong(reader.readLine());
                categoryDbList.add(categoryDao.getById(categoryId));
            }
            ProductDto productDto = new ProductDto();
            productDto.setName(name);
            productDto.setProducer(producer);
            productDto.setCategoryList(categoryDbList);
            facade.addProduct(productDto);
            System.out.println("product successfully created");
        } catch (Exception e) {
            LOG.error("can not create product");
        }
    }
}
