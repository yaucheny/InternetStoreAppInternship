package com.exposit.actions.order;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.Action;
import com.exposit.api.dao.CustomerDao;
import com.exposit.api.dao.OrderItemDao;
import com.exposit.domain.dto.OrderDto;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.domain.model.entity.OrderStatusEntity;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
public class AddOrderImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(AddOrderImpl.class);
    private final Facade facade;
    private final OrderItemDao orderItemDao;
    private final CustomerDao customerDao;

    @Override
    public void execute() {
        try {
            System.out.println("Enter date of order");
            System.out.println("format of date YYYY-MM-DD");
            LocalDate dateOfOrder = LocalDate.parse(reader.readLine());
            System.out.println("Enter date of delivery");
            System.out.println("format of date YYYY-MM-DD");
            LocalDate dateOfDelivery = LocalDate.parse(reader.readLine());
            System.out.println("Enter customer of order");
            Long customerId = Long.parseLong(reader.readLine());
            System.out.println("Enter amount days of delivery");
            Long days = Long.parseLong(reader.readLine());
            System.out.println("Enter price of purchase");
            Double price = Double.parseDouble(reader.readLine());
            System.out.println("Enter order status");
            System.out.println("choose from DELIVERED, NOT_DELIVERED");
            String status = reader.readLine().toUpperCase();
            System.out.println("Enter id of order items of order");
            System.out.println("to escape entering enter 0");
            List<OrderItemDb> orderItemDbList = new ArrayList<>();
            while (!"0".equals(reader.readLine())) {
                Long orderItemId = Long.parseLong(reader.readLine());
                orderItemDbList.add(orderItemDao.getById(orderItemId));
            }
            OrderDto orderDto = new OrderDto();
            orderDto.setCustomer(customerDao.getById(customerId));
            orderDto.setDateOfDelivery(dateOfDelivery);
            orderDto.setDateOfOrder(dateOfOrder);
            orderDto.setDays(days);
            orderDto.setOrderItemList(orderItemDbList);
            orderDto.setOrderStatusEntity(OrderStatusEntity.valueOf(status));
            orderDto.setPriceOfPurchase(price);
            facade.addOrder(orderDto);
            System.out.println("order successfully created");
        } catch (Exception e) {
            LOG.error("can not create order");
        }
    }
}
