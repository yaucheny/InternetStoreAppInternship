package com.exposit.actions.orderitem;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.Action;
import com.exposit.api.dao.ShopProductDao;
import com.exposit.domain.dto.OrderItemDto;
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
public class UpdateOrderItemImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateOrderItemImpl.class);
    private final Facade facade;
    private final ShopProductDao shopProductDao;

    @Override
    public void execute() {
        try {
            System.out.println("Enter id of orderItem to be updated");
            Long orderItemId = Long.parseLong(reader.readLine());
            System.out.println("Enter quantity of products in order");
            Integer quantity = Integer.parseInt(reader.readLine());
            System.out.println("Enter shop product id of product in order");
            Long shopProductId = Long.parseLong(reader.readLine());
            OrderItemDto orderItemDto = new OrderItemDto();
            orderItemDto.setQuantity(quantity);
            orderItemDto.setShopProduct(shopProductDao.getById(shopProductId));
            facade.updateOrderItem(orderItemId, orderItemDto);
            System.out.println("orderItem id :" + orderItemId + " updated");
        } catch (Exception e) {
            LOG.error("can not update orderItem");
        }
    }
}
