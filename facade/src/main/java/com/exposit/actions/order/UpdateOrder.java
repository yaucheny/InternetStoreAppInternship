package com.exposit.actions.order;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import lombok.extern.log4j.Log4j;

@Log4j
public class UpdateOrder extends AbstractAction implements IAction {
//    private static final CustomerService CUSTOMER_SERVICE
//            = CustomerServiceImpl.getInstance();
//    private static final ShopProductService SHOP_PRODUCT_SERVICE
//            = ShopProductServiceImpl.getInstance();

    @Override
    public void execute() {
//        try {
//            System.out.println("Enter id of order to be updated");
//            Long orderId = Long.parseLong(reader.readLine());
//
//            System.out.println("Enter new number of days of delivery");
//            Long days = Long.parseLong(reader.readLine());
//
//            System.out.println("Enter new id Of customer");
//            Long customerId = Long.parseLong(reader.readLine());
//            CustomerEntity customer = CUSTOMER_SERVICE.getCustomerById(customerId);
//            int i = 1;
//            List<OrderItemEntity> orderItems = new ArrayList<>();
//            Map<ShopProductEntity, Integer> mapOfGoods = new HashMap<>();
//            while (i != 0) {
//                System.out.println("Enter new quantity of products");
//                Integer quantity = Integer.parseInt(reader.readLine());
//
//
//                System.out.println(
//                        "Enter new id of product to add to the order");
//                Long productId = Long.parseLong(reader.readLine());
//                ShopProductEntity shopProduct
//                        = SHOP_PRODUCT_SERVICE.getShopProductById(productId);
//                mapOfGoods.put(shopProduct, quantity);
//
//
//                System.out.println("Press '1' to continue or '0' to escape");
//                i = Integer.parseInt(reader.readLine());
//            }
//            fasade.updateOrder(orderId, days, customer, orderItems);
//            System.out.println("order id :" + orderId + " updated");
//        } catch (Exception e) {
//            log.warn(e.getLocalizedMessage());
//        }
    }
}
