package com.exposit.actions.order;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;

public class AddOrder extends AbstractAction implements IAction {
//    private static final CustomerService CUSTOMER_SERVICE
//            = CustomerServiceImpl.getInstance();
//    private static final ShopProductService SHOP_PRODUCT_SERVICE
//            = ShopProductServiceImpl.getInstance();

    @Override
    public void execute() {
//        try {
//
//            System.out.println("Enter number of days of delivery");
//            Long days = Long.parseLong(reader.readLine());
//
//            System.out.println("Enter id Of customer");
//            Long customerId = Long.parseLong(reader.readLine());
//            CustomerEntity customer = CUSTOMER_SERVICE
//            .getCustomerById(customerId);
//            int i = 1;
//            List<OrderItemEntity> orderItems = new ArrayList<>();
//            Map<ShopProductEntity, Integer> mapOfGoods = new HashMap<>();
//            while (i != 0) {
//                System.out.println("Enter quantity of products");
//                Integer quantity = Integer.parseInt(reader.readLine());
//
//                System.out.println(
//                        "Enter id of product to add to the order");
//                Long productId = Long.parseLong(reader.readLine());
//                ShopProductEntity shopProduct = SHOP_PRODUCT_SERVICE
//                        .getShopProductById(productId);
//                mapOfGoods.put(shopProduct, quantity);
//
//                System.out.println(
//                        "Press '1' to continue or '0' to end the order");
//                i = Integer.parseInt(reader.readLine());
//
//            }
//            fasade.addOrder(days, customer, orderItems);
//            System.out.println("order successfully created");
//        } catch (Exception e) {
//            log.warn(e.getLocalizedMessage());
//        }
    }
}
