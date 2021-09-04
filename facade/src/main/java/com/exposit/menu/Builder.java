package com.exposit.menu;

import com.exposit.actions.category.AddCategory;
import com.exposit.actions.category.DeleteCategory;
import com.exposit.actions.category.GetAllCategory;
import com.exposit.actions.category.GetByIdCategory;
import com.exposit.actions.category.SaveToFileCategory;
import com.exposit.actions.category.UpdateCategory;
import com.exposit.actions.customer.AddCustomer;
import com.exposit.actions.customer.DeleteCustomer;
import com.exposit.actions.customer.GetAllCustomer;
import com.exposit.actions.customer.GetByIdCustomer;
import com.exposit.actions.customer.SaveToFileCustomer;
import com.exposit.actions.customer.UpdateCustomer;
import com.exposit.actions.order.AddOrder;
import com.exposit.actions.order.DeleteOrder;
import com.exposit.actions.order.GetAllOrder;
import com.exposit.actions.order.GetByIdOrder;
import com.exposit.actions.order.SaveToFileOrder;
import com.exposit.actions.order.UpdateOrder;
import com.exposit.actions.orderitem.AddOrderItem;
import com.exposit.actions.orderitem.DeleteOrderItem;
import com.exposit.actions.orderitem.GetAllOrderItem;
import com.exposit.actions.orderitem.GetByIdOrderItem;
import com.exposit.actions.orderitem.SaveToFileOrderItem;
import com.exposit.actions.orderitem.UpdateOrderItem;
import com.exposit.actions.product.AddProduct;
import com.exposit.actions.product.DeleteProduct;
import com.exposit.actions.product.GetAllProduct;
import com.exposit.actions.product.GetByIdProduct;
import com.exposit.actions.product.SaveToFileProduct;
import com.exposit.actions.product.UpdateProduct;
import com.exposit.actions.shopproduct.AddShopProduct;
import com.exposit.actions.shopproduct.DeleteShopProduct;
import com.exposit.actions.shopproduct.FindShopProductByOneAttribute;
import com.exposit.actions.shopproduct.FindShopProductByTwoAttribute;
import com.exposit.actions.shopproduct.GetAllShopProduct;
import com.exposit.actions.shopproduct.GetByIdShopProduct;
import com.exposit.actions.shopproduct.GetShopProductFromCategory;
import com.exposit.actions.shopproduct.InfoAboutPriceQuantityInStore;
import com.exposit.actions.shopproduct.SortShopProductByPrice;
import com.exposit.actions.shopproduct.UpdateShopProduct;
import com.exposit.actions.store.AddStore;
import com.exposit.actions.store.DeleteStore;
import com.exposit.actions.store.GetAllStore;
import com.exposit.actions.store.GetByIdStore;
import com.exposit.actions.store.SaveToFileStore;
import com.exposit.actions.store.UpdateStore;

import java.util.Objects;

public class Builder {
    private static Builder instance;
    private Menu rootMenu;

    private Builder() {

    }

    public static Builder getInstance() {
        instance = Objects.requireNonNullElse(instance, new Builder());
        return instance;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void buildMenu() {
        rootMenu = new Menu();
        rootMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        rootMenu.addMenuItem(new MenuItem("Store Menu",
                () -> System.out.println(""), createStoreMenu()));
        rootMenu.addMenuItem(new MenuItem("Customer Menu",
                () -> System.out.println(""), createCustomerMenu()));
        rootMenu.addMenuItem(new MenuItem("Order Menu",
                () -> System.out.println(""), createOrderMenu()));
        rootMenu.addMenuItem(new MenuItem("OrderItem Menu",
                () -> System.out.println(""), createOrderItemMenu()));
        rootMenu.addMenuItem(new MenuItem("Product Menu",
                () -> System.out.println(""), createShopProductMenu()));
        rootMenu.addMenuItem(new MenuItem("ShopProduct Menu",
                () -> System.out.println(""), createProductMenu()));
        rootMenu.addMenuItem(new MenuItem("Category Menu",
                () -> System.out.println(""), createCategoryMenu()));
    }

    private Menu createStoreMenu() {
        var storeMenu = new Menu();
        storeMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        storeMenu.addMenuItem(new MenuItem("Add new store",
                new AddStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Update store",
                new UpdateStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Delete store",
                new DeleteStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Get by id store",
                new GetByIdStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Get all stores",
                new GetAllStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Save stores to file",
                new SaveToFileStore(), rootMenu));
        return storeMenu;
    }

    private Menu createCustomerMenu() {
        var customerMenu = new Menu();
        customerMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        customerMenu.addMenuItem(new MenuItem("Add customer",
                new AddCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("Update customer",
                new UpdateCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("Delete customer",
                new DeleteCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("GetById customer",
                new GetByIdCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("Get All customer",
                new GetAllCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("Save customer to file",
                new SaveToFileCustomer(), rootMenu));
        return customerMenu;
    }

    private Menu createCategoryMenu() {
        var categoryMenu = new Menu();
        categoryMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        categoryMenu.addMenuItem(new MenuItem("Add category",
                new AddCategory(), rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Update category",
                new UpdateCategory(), rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Delete category",
                new DeleteCategory(), rootMenu));
        categoryMenu.addMenuItem(new MenuItem("GetById category",
                new GetByIdCategory(), rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Get All category",
                new GetAllCategory(), rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Save category to file",
                new SaveToFileCategory(), rootMenu));
        return categoryMenu;
    }

    private Menu createOrderMenu() {
        var orderMenu = new Menu();
        orderMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        orderMenu.addMenuItem(new MenuItem("Add order",
                new AddOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Delete order",
                new DeleteOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Update order",
                new UpdateOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Get by id order",
                new GetByIdOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("get all order",
                new GetAllOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Save stores to order",
                new SaveToFileOrder(), rootMenu));
        return orderMenu;
    }

    private Menu createProductMenu() {
        var productMenu = new Menu();
        productMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        productMenu.addMenuItem(new MenuItem("Add product",
                new AddProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Delete product",
                new DeleteProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Update product",
                new UpdateProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Get by id product",
                new GetByIdProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("get all product",
                new GetAllProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Save products to file",
                new SaveToFileProduct(), rootMenu));
        return productMenu;
    }

    private Menu createOrderItemMenu() {
        var orderItemMenu = new Menu();
        orderItemMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        orderItemMenu.addMenuItem(new MenuItem("Add orderItem",
                new AddOrderItem(), rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Delete orderItem",
                new DeleteOrderItem(), rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Update orderItem",
                new UpdateOrderItem(), rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Get by id orderItem",
                new GetByIdOrderItem(), rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("get all orderItem",
                new GetAllOrderItem(), rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Save orderItem to file",
                new SaveToFileOrderItem(), rootMenu));
        return orderItemMenu;
    }

    private Menu createShopProductMenu() {
        var shopProductMenu = new Menu();
        shopProductMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        shopProductMenu.addMenuItem(new MenuItem("Add shopProduct",
                new AddShopProduct(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Delete shopProduct",
                new DeleteShopProduct(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Update shopProduct",
                new UpdateShopProduct(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get by id shopProduct",
                new GetByIdShopProduct(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get all shopProducts",
                new GetAllShopProduct(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Sort all products by shopPrice",
                new SortShopProductByPrice(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Find shopProduct by one attribute",
                new FindShopProductByOneAttribute(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Find shopProduct by two attributes",
                new FindShopProductByTwoAttribute(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get shopProduct from category",
                new GetShopProductFromCategory(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem(
                "Get info about product's price and quantity in store",
                new InfoAboutPriceQuantityInStore(), rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Save shopProducts to file",
                new GetAllStore(), rootMenu));
        return shopProductMenu;
    }
}
