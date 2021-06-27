package com.exposit.actions.order;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.api.service.ICustomerService;
import com.exposit.api.service.IProductService;
import com.exposit.model.Customer;
import com.exposit.model.Product;
import com.exposit.service.CustomerService;
import com.exposit.service.ProductService;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

@Log4j
public class AddOrder extends AbstractAction implements IAction {
    private static final ICustomerService customerService = CustomerService.getInstance();
    private static final IProductService goodsService = ProductService.getInstance();

    @Override
    public void execute() {
        try {

            System.out.println("Enter number of days of delivery");
            Long days = Long.parseLong(reader.readLine());

            System.out.println("Enter id Of customer");
            Long customerId = Long.parseLong(reader.readLine());
            Customer customer = customerService.getCustomerById(customerId);
            int i = 1;
            Map<Product, Integer> mapOfGoods = new HashMap<>();
            while (i != 0) {
                System.out.println("Enter quantity of products");
                Integer quantity = Integer.parseInt(reader.readLine());

                System.out.println("Enter id of product to add to the order");
                Long goodsId = Long.parseLong(reader.readLine());
                Product product = goodsService.getProductById(goodsId);
                mapOfGoods.put(product, quantity);

                System.out.println("Press '1' to continue or '0' to end the order");
                i = Integer.parseInt(reader.readLine());

            }
            fasade.addOrder(days, customer, mapOfGoods);
            System.out.println("order successfully created");
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
        }
    }
}
