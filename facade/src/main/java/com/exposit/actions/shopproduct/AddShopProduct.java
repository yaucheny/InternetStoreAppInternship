package com.exposit.actions.shopproduct;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.api.dao.ProductDao;
import com.exposit.api.dao.StoreDao;
import com.exposit.domain.dto.ShopProductDto;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddShopProduct extends AbstractAction implements IAction {

    private static final Logger LOG = LoggerFactory.getLogger(AddShopProduct.class);
    private final Facade facade;
    private final ProductDao productDao;
    private final StoreDao storeDao;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of product to sell in store");
            Long productId = Long.parseLong(reader.readLine());
            System.out.println("Enter id of store to sell product");
            Long storeId = Long.parseLong(reader.readLine());
            System.out.println("Enter quantity of product in store");
            Integer quantity = Integer.parseInt(reader.readLine());
            System.out.println("Enter price of product in store");
            Double price = Double.parseDouble(reader.readLine());
            System.out.println("Enter description of product in store");
            String description = reader.readLine();
            ShopProductDto shopProductDto = new ShopProductDto();
            shopProductDto.setDescription(description);
            shopProductDto.setPrice(price);
            shopProductDto.setProduct(productDao.getById(productId));
            shopProductDto.setStore(storeDao.getById(storeId));
            shopProductDto.setQuantity(quantity);
            facade.addShopProduct(shopProductDto);
            System.out.println("shopProduct successfully created");
        } catch (Exception e) {
            LOG.error("can not create shopProduct");
        }
    }
}
