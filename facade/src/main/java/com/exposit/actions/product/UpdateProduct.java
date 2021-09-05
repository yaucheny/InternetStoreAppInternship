package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
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

@Component
@RequiredArgsConstructor
public class UpdateProduct extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateProduct.class);
    private final Facade facade;
    private final CategoryDao categoryDao;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of product to be updated");
            Long productId = Long.parseLong(reader.readLine());
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
            facade.updateProduct(productId, productDto);
            System.out.println("product id :" + productId + " updated");
        } catch (Exception e) {
            LOG.error("can not update product");
        }
    }
}
