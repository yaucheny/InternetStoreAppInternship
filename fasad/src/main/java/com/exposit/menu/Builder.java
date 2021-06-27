package com.exposit.menu;

import com.exposit.actions.customer.*;
import com.exposit.actions.product.*;
import com.exposit.actions.order.*;
import com.exposit.actions.save.SaveCustomerToFile;
import com.exposit.actions.save.SaveOrderToFile;
import com.exposit.actions.save.SaveProductToFile;
import com.exposit.actions.save.SaveStoreToFile;
import com.exposit.actions.store.*;

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
        rootMenu.addMenuItem(new MenuItem("Exit", () -> {
            System.out.println("");
        }, null));
        rootMenu.addMenuItem(new MenuItem("Store Menu", () -> {
            System.out.println("");
        }, createStoreMenu()));
        rootMenu.addMenuItem(new MenuItem("Customer Menu", () -> {
            System.out.println("");
        }, createCustomerMenu()));
        rootMenu.addMenuItem(new MenuItem("Order Menu", () -> {
            System.out.println("");
        }, createOrderMenu()));
        rootMenu.addMenuItem(new MenuItem("Product Menu", () -> {
            System.out.println("");
        }, createGoodsMenu()));
        rootMenu.addMenuItem(new MenuItem("Save Menu", () -> {
            System.out.println("");
        }, createSaveMenu()));

    }

    private Menu createSaveMenu() {

        var saveMenu = new Menu();
        saveMenu.addMenuItem(new MenuItem("Exit", () -> {
            System.out.println("");
        }, null));
        saveMenu.addMenuItem(new MenuItem("Sava all customers to file", new SaveCustomerToFile(), rootMenu));
        saveMenu.addMenuItem(new MenuItem("Sava all orders to file", new SaveOrderToFile(), rootMenu));
        saveMenu.addMenuItem(new MenuItem("Sava all stores to file", new SaveStoreToFile(), rootMenu));
        saveMenu.addMenuItem(new MenuItem("Sava all products to file", new SaveProductToFile(), rootMenu));

        return saveMenu;
    }


    private Menu createStoreMenu() {
        var storeMenu = new Menu();
        storeMenu.addMenuItem(new MenuItem("Exit", () -> {
            System.out.println("");
        }, null));
        storeMenu.addMenuItem(new MenuItem("Add new store", new AddStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Update store", new UpdateStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Delete store", new DeleteStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Get by id store", new GetByIdStore(), rootMenu));
        storeMenu.addMenuItem(new MenuItem("Get all stores", new GetAllStore(), rootMenu));

        return storeMenu;
    }


    private Menu createCustomerMenu() {
        var customerMenu = new Menu();
        customerMenu.addMenuItem(new MenuItem("Exit", () -> {
            System.out.println("");
        }, null));
        customerMenu.addMenuItem(new MenuItem("Add customer", new AddCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("Update customer", new UpdateCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("Delete customer", new DeleteCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("GetById customer", new GetByIdCustomer(), rootMenu));
        customerMenu.addMenuItem(new MenuItem("Get All customer", new GetAllCustomer(), rootMenu));

        return customerMenu;
    }


    private Menu createOrderMenu() {

        var orderMenu = new Menu();
        orderMenu.addMenuItem(new MenuItem("Exit", () -> {
            System.out.println("");
        }, null));
        orderMenu.addMenuItem(new MenuItem("Add order", new AddOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Delete order", new DeleteOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Update order", new UpdateOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Get by id order", new GetByIdOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("get all order", new GetAllOrder(), rootMenu));

        return orderMenu;
    }

    private Menu createGoodsMenu() {

        var productMenu = new Menu();
        productMenu.addMenuItem(new MenuItem("Exit", () -> {
            System.out.println("");
        }, null));
        productMenu.addMenuItem(new MenuItem("Add product", new AddProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Delete product", new DeleteProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Update product", new UpdateProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Get by id product", new GetByIdProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Get all products", new GetAllProduct(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Sort all products by price", new SortProductByPrice(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Find product by one attribute", new FindProductByOneAttribute(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Find product by two attributes",new FindProductByTwoAttribute(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Get product from category", new GetProductFromCategory(), rootMenu));
        productMenu.addMenuItem(new MenuItem("Get info about product's price and quantity in store", new InfoAboutPriceQuantityInStore(), rootMenu));
        return productMenu;
    }

}
