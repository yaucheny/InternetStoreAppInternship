package com.exposit.menu;

import com.exposit.actions.customer.AddCustomer;
import com.exposit.actions.customer.DeleteCustomer;
import com.exposit.actions.customer.GetByIdCustomer;
import com.exposit.actions.customer.UpdateCustomer;
import com.exposit.actions.customer.GetAllCustomer;
import com.exposit.actions.order.AddOrder;
import com.exposit.actions.order.DeleteOrder;
import com.exposit.actions.order.GetByIdOrder;
import com.exposit.actions.order.UpdateOrder;
import com.exposit.actions.order.GetAllOrder;
import com.exposit.actions.product.AddProduct;
import com.exposit.actions.product.DeleteProduct;
import com.exposit.actions.product.FindProductByOneAttribute;
import com.exposit.actions.product.FindProductByTwoAttribute;
import com.exposit.actions.product.GetAllProduct;
import com.exposit.actions.product.GetByIdProduct;
import com.exposit.actions.product.GetProductFromCategory;
import com.exposit.actions.product.InfoAboutPriceQuantityInStore;
import com.exposit.actions.product.SortProductByPrice;
import com.exposit.actions.product.UpdateProduct;
import com.exposit.actions.save.savetojson.SaveCustomerToFileJson;
import com.exposit.actions.save.savetojson.SaveOrderToFileJson;
import com.exposit.actions.save.savetojson.SaveProductToFileJson;
import com.exposit.actions.save.savetojson.SaveStoreToFileJson;
import com.exposit.actions.store.AddStore;
import com.exposit.actions.store.DeleteStore;
import com.exposit.actions.store.GetByIdStore;
import com.exposit.actions.store.UpdateStore;
import com.exposit.actions.store.GetAllStore;

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
        rootMenu.addMenuItem(new MenuItem("Product Menu",
                () -> System.out.println(""), createGoodsMenu()));
        rootMenu.addMenuItem(new MenuItem("Save Menu",
                () -> System.out.println(""), createSaveMenu()));

    }

    private Menu createSaveMenu() {

        var saveMenu = new Menu();
        saveMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        saveMenu.addMenuItem(new MenuItem("Save entities to JSON",
                new SaveCustomerToFileJson(), createSaveJsonMenu()));
        saveMenu.addMenuItem(new MenuItem("Save entities to XML",
                new SaveOrderToFileJson(), createSaveXMLMenu()));


        return saveMenu;
    }

    private Menu createSaveXMLMenu() {

        var saveXMLMenu = new Menu();
        saveXMLMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        saveXMLMenu.addMenuItem(
                new MenuItem("Sava all customers to file in XML",
                new SaveCustomerToFileJson(), rootMenu));
        saveXMLMenu.addMenuItem(
                new MenuItem("Sava all orders to file in XML",
                new SaveOrderToFileJson(), rootMenu));
        saveXMLMenu.addMenuItem(
                new MenuItem("Sava all orderItems to file in XML",
                new SaveStoreToFileJson(), rootMenu));
        saveXMLMenu.addMenuItem(
                new MenuItem("Sava all products to file in XML",
                new SaveProductToFileJson(), rootMenu));
        saveXMLMenu.addMenuItem(
                new MenuItem("Sava all shopProducts to file in XML",
                new SaveProductToFileJson(), rootMenu));
        saveXMLMenu.addMenuItem(
                new MenuItem("Sava all categories to file in XML",
                new SaveProductToFileJson(), rootMenu));

        return saveXMLMenu;
    }

    private Menu createSaveJsonMenu() {

        var saveJsonMenu = new Menu();
        saveJsonMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        saveJsonMenu.addMenuItem(
                new MenuItem("Sava all customers to file in JSON",
                new SaveCustomerToFileJson(), rootMenu));
        saveJsonMenu.addMenuItem(
                new MenuItem("Sava all orders to file in JSON",
                new SaveOrderToFileJson(), rootMenu));
        saveJsonMenu.addMenuItem(
                new MenuItem("Sava all orderItems to file in JSON",
                new SaveStoreToFileJson(), rootMenu));
        saveJsonMenu.addMenuItem(
                new MenuItem("Sava all products to file in JSON",
                new SaveProductToFileJson(), rootMenu));
        saveJsonMenu.addMenuItem(
                new MenuItem("Sava all shopProducts to file in JSON",
                new SaveProductToFileJson(), rootMenu));
        saveJsonMenu.addMenuItem(
                new MenuItem("Sava all categories to file in JSON",
                new SaveProductToFileJson(), rootMenu));

        return saveJsonMenu;
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

        return customerMenu;
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

        return orderMenu;
    }

    private Menu createGoodsMenu() {

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
        productMenu.addMenuItem(new MenuItem("Get all products",
                new GetAllProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Sort all products by price",
                new SortProductByPrice(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Find product by one attribute",
                new FindProductByOneAttribute(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Find product by two attributes",
                new FindProductByTwoAttribute(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Get product from category",
                new GetProductFromCategory(), rootMenu));
        productMenu.addMenuItem(new MenuItem(
                "Get info about product's price and quantity in store",
                new InfoAboutPriceQuantityInStore(), rootMenu));
        return productMenu;
    }

}
