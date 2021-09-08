package com.exposit.actions.shopproduct;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.Action;
import com.exposit.api.dao.ProductDao;
import com.exposit.api.dao.StoreDao;
import com.exposit.domain.dto.ShopProductDto;
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
public class UpdateShopProductImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateShopProductImpl.class);
    private final Facade facade;
    private final ProductDao productDao;
    private final StoreDao storeDao;

    @Override
    public void execute() {

        try {
            System.out.println("Enter id of shopProduct to be updated");
            Long shopProductId = Long.parseLong(reader.readLine());
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
            facade.updateShopProduct(shopProductId, shopProductDto);
            System.out.println("shopProduct id :" + shopProductId + " updated");
        } catch (Exception e) {
            LOG.error("can not update shopProduct");
        }
    }
}
