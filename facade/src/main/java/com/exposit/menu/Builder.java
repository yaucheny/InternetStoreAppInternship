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
import com.exposit.actions.shopproduct.SaveToFileShopProduct;
import com.exposit.actions.shopproduct.SortShopProductByPrice;
import com.exposit.actions.shopproduct.UpdateShopProduct;
import com.exposit.actions.store.AddStore;
import com.exposit.actions.store.DeleteStore;
import com.exposit.actions.store.GetAllStore;
import com.exposit.actions.store.GetByIdStore;
import com.exposit.actions.store.SaveToFileStore;
import com.exposit.actions.store.UpdateStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class Builder {

    private Menu rootMenu;
    private final AddCategory addCategory;
    private final DeleteCategory deleteCategory;
    private final UpdateCategory updateCategory;
    private final GetByIdCategory getByIdCategory;
    private final GetAllCategory getAllCategory;
    private final SaveToFileCategory saveToFileCategory;


    private final AddCustomer addCustomer;
    private final DeleteCustomer deleteCustomer;
    private final UpdateCustomer updateCustomer;
    private final GetByIdCustomer getByIdCustomer;
    private final GetAllCustomer getAllCustomer;
    private final SaveToFileCustomer saveToFileCustomer;


    private final AddOrder addOrder;
    private final DeleteOrder deleteOrder;
    private final UpdateOrder updateOrder;
    private final GetByIdOrder getByIdOrder;
    private final GetAllOrder getAllOrder;
    private final SaveToFileOrder saveToFileOrder;


    private final AddOrderItem addOrderItem;
    private final DeleteOrderItem deleteOrderItem;
    private final UpdateOrderItem updateOrderItem;
    private final GetByIdOrderItem getByIdOrderItem;
    private final GetAllOrderItem getAllOrderItem;
    private final SaveToFileOrderItem saveToFileOrderItem;


    private final AddProduct addProduct;
    private final DeleteProduct deleteProduct;
    private final UpdateProduct updateProduct;
    private final GetByIdProduct getByIdProduct;
    private final GetAllProduct getAllProduct;
    private final FindShopProductByOneAttribute findShopProductByOneAttribute;
    private final FindShopProductByTwoAttribute findShopProductByTwoAttribute;
    private final GetShopProductFromCategory getShopProductFromCategory;
    private final InfoAboutPriceQuantityInStore infoAboutPriceQuantityInStore;
    private final SortShopProductByPrice sortShopProductByPrice;
    private final SaveToFileProduct saveToFileProduct;


    private final AddShopProduct addShopProduct;
    private final DeleteShopProduct deleteShopProduct;
    private final UpdateShopProduct updateShopProduct;
    private final GetByIdShopProduct getByIdShopProduct;
    private final GetAllShopProduct getAllShopProduct;
    private final SaveToFileShopProduct saveToFileShopProduct;


    private final AddStore addStore;
    private final DeleteStore deleteStore;
    private final UpdateStore updateStore;
    private final GetByIdStore getByIdStore;
    private final GetAllStore getAllStore;
    private final SaveToFileStore saveToFileStore;

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
                addStore, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Update store",
                updateStore, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Delete store",
                deleteStore, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Get by id store",
               getByIdStore, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Get all stores",
               getAllStore, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Save stores to file",
                saveToFileStore, rootMenu));
        return storeMenu;
    }

    private Menu createCustomerMenu() {
        var customerMenu = new Menu();
        customerMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        customerMenu.addMenuItem(new MenuItem("Add customer",
               addCustomer, rootMenu));
        customerMenu.addMenuItem(new MenuItem("Update customer",
                updateCustomer, rootMenu));
        customerMenu.addMenuItem(new MenuItem("Delete customer",
                deleteCustomer, rootMenu));
        customerMenu.addMenuItem(new MenuItem("GetById customer",
                getByIdCustomer, rootMenu));
        customerMenu.addMenuItem(new MenuItem("Get All customer",
                getAllCustomer, rootMenu));
        customerMenu.addMenuItem(new MenuItem("Save customer to file",
                saveToFileCustomer, rootMenu));
        return customerMenu;
    }

    private Menu createCategoryMenu() {
        var categoryMenu = new Menu();
        categoryMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        categoryMenu.addMenuItem(new MenuItem("Add category",
                addCategory, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Update category",
                updateCategory, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Delete category",
                deleteCategory, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("GetById category",
                getByIdCategory, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Get All category",
                getAllCategory, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Save category to file",
                saveToFileCategory, rootMenu));
        return categoryMenu;
    }

    private Menu createOrderMenu() {
        var orderMenu = new Menu();
        orderMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        orderMenu.addMenuItem(new MenuItem("Add order",
                addOrder, rootMenu));
        orderMenu.addMenuItem(new MenuItem("Delete order",
                deleteOrder, rootMenu));
        orderMenu.addMenuItem(new MenuItem("Update order",
                updateOrder, rootMenu));
        orderMenu.addMenuItem(new MenuItem("Get by id order",
                getByIdOrder, rootMenu));
        orderMenu.addMenuItem(new MenuItem("get all order",
                getAllOrder, rootMenu));
        orderMenu.addMenuItem(new MenuItem("Save stores to order",
                saveToFileOrder, rootMenu));
        return orderMenu;
    }

    private Menu createProductMenu() {
        var productMenu = new Menu();
        productMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        productMenu.addMenuItem(new MenuItem("Add product",
               addProduct, rootMenu));
        productMenu.addMenuItem(new MenuItem("Delete product",
                deleteProduct, rootMenu));
        productMenu.addMenuItem(new MenuItem("Update product",
                updateProduct, rootMenu));
        productMenu.addMenuItem(new MenuItem("Get by id product",
                getByIdProduct, rootMenu));
        productMenu.addMenuItem(new MenuItem("get all product",
                getAllProduct, rootMenu));
        productMenu.addMenuItem(new MenuItem("Save products to file",
                saveToFileProduct, rootMenu));
        return productMenu;
    }

    private Menu createOrderItemMenu() {
        var orderItemMenu = new Menu();
        orderItemMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        orderItemMenu.addMenuItem(new MenuItem("Add orderItem",
                addOrderItem, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Delete orderItem",
                deleteOrderItem, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Update orderItem",
                updateOrderItem, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Get by id orderItem",
                getByIdOrderItem, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("get all orderItem",
                getAllOrderItem, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Save orderItem to file",
                saveToFileOrderItem, rootMenu));
        return orderItemMenu;
    }

    private Menu createShopProductMenu() {
        var shopProductMenu = new Menu();
        shopProductMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        shopProductMenu.addMenuItem(new MenuItem("Add shopProduct",
                addShopProduct, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Delete shopProduct",
               deleteShopProduct, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Update shopProduct",
                updateShopProduct, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get by id shopProduct",
                getByIdShopProduct, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get all shopProducts",
                getAllShopProduct, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Sort all products by shopPrice",
                sortShopProductByPrice, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Find shopProduct by one attribute",
                findShopProductByOneAttribute, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Find shopProduct by two attributes",
                findShopProductByTwoAttribute, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get shopProduct from category",
                getShopProductFromCategory, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem(
                "Get info about product's price and quantity in store",
                infoAboutPriceQuantityInStore, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Save shopProducts to file",
                saveToFileShopProduct, rootMenu));
        return shopProductMenu;
    }
}
