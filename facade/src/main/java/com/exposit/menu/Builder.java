package com.exposit.menu;

import com.exposit.actions.category.AddCategoryImpl;
import com.exposit.actions.category.DeleteCategoryImpl;
import com.exposit.actions.category.GetAllCategoryImpl;
import com.exposit.actions.category.GetByIdCategoryImpl;
import com.exposit.actions.category.SaveToFileCategoryImpl;
import com.exposit.actions.category.UpdateCategoryImpl;
import com.exposit.actions.customer.AddCustomerImpl;
import com.exposit.actions.customer.DeleteCustomerImpl;
import com.exposit.actions.customer.GetAllCustomerImpl;
import com.exposit.actions.customer.GetByIdCustomerImpl;
import com.exposit.actions.customer.SaveToFileCustomerImpl;
import com.exposit.actions.customer.UpdateCustomerImpl;
import com.exposit.actions.order.AddOrderImpl;
import com.exposit.actions.order.DeleteOrderImpl;
import com.exposit.actions.order.GetAllOrderImpl;
import com.exposit.actions.order.GetByIdOrderImpl;
import com.exposit.actions.order.SaveToFileOrderImpl;
import com.exposit.actions.order.UpdateOrderImpl;
import com.exposit.actions.orderitem.AddOrderItemImpl;
import com.exposit.actions.orderitem.DeleteOrderItemImpl;
import com.exposit.actions.orderitem.GetAllOrderItemImpl;
import com.exposit.actions.orderitem.GetByIdOrderItemImpl;
import com.exposit.actions.orderitem.SaveToFileOrderItemImpl;
import com.exposit.actions.orderitem.UpdateOrderItemImpl;
import com.exposit.actions.product.AddProductImpl;
import com.exposit.actions.product.DeleteProductImpl;
import com.exposit.actions.product.GetAllProductImpl;
import com.exposit.actions.product.GetByIdProductImpl;
import com.exposit.actions.product.SaveToFileProductImpl;
import com.exposit.actions.product.UpdateProductImpl;
import com.exposit.actions.shopproduct.AddShopProductImpl;
import com.exposit.actions.shopproduct.DeleteShopProductImpl;
import com.exposit.actions.shopproduct.FindShopProductByOneAttributeImpl;
import com.exposit.actions.shopproduct.FindShopProductByTwoAttributeImpl;
import com.exposit.actions.shopproduct.GetAllShopProductImpl;
import com.exposit.actions.shopproduct.GetByIdShopProductImpl;
import com.exposit.actions.shopproduct.GetShopProductFromCategoryImpl;
import com.exposit.actions.shopproduct.InfoAboutPriceQuantityInStoreImpl;
import com.exposit.actions.shopproduct.SaveToFileShopProductImpl;
import com.exposit.actions.shopproduct.SortShopProductByPriceImpl;
import com.exposit.actions.shopproduct.UpdateShopProductImpl;
import com.exposit.actions.store.AddStoreImpl;
import com.exposit.actions.store.DeleteStoreImpl;
import com.exposit.actions.store.GetAllStoreImpl;
import com.exposit.actions.store.GetByIdStoreImpl;
import com.exposit.actions.store.SaveToFileStoreImpl;
import com.exposit.actions.store.UpdateStoreImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Class builds console menu.
 * Every position of menu is linked to special action {@link com.exposit.actions}
 * Every choice of menu position is linked to class which invokes method.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class Builder {

    private Menu rootMenu;
    private final AddCategoryImpl addCategoryImpl;
    private final DeleteCategoryImpl deleteCategoryImpl;
    private final UpdateCategoryImpl updateCategoryImpl;
    private final GetByIdCategoryImpl getByIdCategoryImpl;
    private final GetAllCategoryImpl getAllCategoryImpl;
    private final SaveToFileCategoryImpl saveToFileCategoryImpl;


    private final AddCustomerImpl addCustomerImpl;
    private final DeleteCustomerImpl deleteCustomerImpl;
    private final UpdateCustomerImpl updateCustomerImpl;
    private final GetByIdCustomerImpl getByIdCustomerImpl;
    private final GetAllCustomerImpl getAllCustomerImpl;
    private final SaveToFileCustomerImpl saveToFileCustomerImpl;


    private final AddOrderImpl addOrderImpl;
    private final DeleteOrderImpl deleteOrderImpl;
    private final UpdateOrderImpl updateOrderImpl;
    private final GetByIdOrderImpl getByIdOrderImpl;
    private final GetAllOrderImpl getAllOrderImpl;
    private final SaveToFileOrderImpl saveToFileOrderImpl;


    private final AddOrderItemImpl addOrderItemImpl;
    private final DeleteOrderItemImpl deleteOrderItemImpl;
    private final UpdateOrderItemImpl updateOrderItemImpl;
    private final GetByIdOrderItemImpl getByIdOrderItemImpl;
    private final GetAllOrderItemImpl getAllOrderItemImpl;
    private final SaveToFileOrderItemImpl saveToFileOrderItemImpl;


    private final AddProductImpl addProductImpl;
    private final DeleteProductImpl deleteProductImpl;
    private final UpdateProductImpl updateProductImpl;
    private final GetByIdProductImpl getByIdProductImpl;
    private final GetAllProductImpl getAllProductImpl;
    private final FindShopProductByOneAttributeImpl findShopProductByOneAttributeImpl;
    private final FindShopProductByTwoAttributeImpl findShopProductByTwoAttributeImpl;
    private final GetShopProductFromCategoryImpl getShopProductFromCategoryImpl;
    private final InfoAboutPriceQuantityInStoreImpl infoAboutPriceQuantityInStoreImpl;
    private final SortShopProductByPriceImpl sortShopProductByPriceImpl;
    private final SaveToFileProductImpl saveToFileProductImpl;


    private final AddShopProductImpl addShopProductImpl;
    private final DeleteShopProductImpl deleteShopProductImpl;
    private final UpdateShopProductImpl updateShopProductImpl;
    private final GetByIdShopProductImpl getByIdShopProductImpl;
    private final GetAllShopProductImpl getAllShopProductImpl;
    private final SaveToFileShopProductImpl saveToFileShopProductImpl;


    private final AddStoreImpl addStoreImpl;
    private final DeleteStoreImpl deleteStoreImpl;
    private final UpdateStoreImpl updateStoreImpl;
    private final GetByIdStoreImpl getByIdStoreImpl;
    private final GetAllStoreImpl getAllStoreImpl;
    private final SaveToFileStoreImpl saveToFileStoreImpl;

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
                addStoreImpl, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Update store",
                updateStoreImpl, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Delete store",
                deleteStoreImpl, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Get by id store",
                getByIdStoreImpl, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Get all stores",
                getAllStoreImpl, rootMenu));
        storeMenu.addMenuItem(new MenuItem("Save stores to file",
                saveToFileStoreImpl, rootMenu));
        return storeMenu;
    }

    private Menu createCustomerMenu() {
        var customerMenu = new Menu();
        customerMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        customerMenu.addMenuItem(new MenuItem("Add customer",
                addCustomerImpl, rootMenu));
        customerMenu.addMenuItem(new MenuItem("Update customer",
                updateCustomerImpl, rootMenu));
        customerMenu.addMenuItem(new MenuItem("Delete customer",
                deleteCustomerImpl, rootMenu));
        customerMenu.addMenuItem(new MenuItem("GetById customer",
                getByIdCustomerImpl, rootMenu));
        customerMenu.addMenuItem(new MenuItem("Get All customer",
                getAllCustomerImpl, rootMenu));
        customerMenu.addMenuItem(new MenuItem("Save customer to file",
                saveToFileCustomerImpl, rootMenu));
        return customerMenu;
    }

    private Menu createCategoryMenu() {
        var categoryMenu = new Menu();
        categoryMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        categoryMenu.addMenuItem(new MenuItem("Add category",
                addCategoryImpl, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Update category",
                updateCategoryImpl, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Delete category",
                deleteCategoryImpl, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("GetById category",
                getByIdCategoryImpl, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Get All category",
                getAllCategoryImpl, rootMenu));
        categoryMenu.addMenuItem(new MenuItem("Save category to file",
                saveToFileCategoryImpl, rootMenu));
        return categoryMenu;
    }

    private Menu createOrderMenu() {
        var orderMenu = new Menu();
        orderMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        orderMenu.addMenuItem(new MenuItem("Add order",
                addOrderImpl, rootMenu));
        orderMenu.addMenuItem(new MenuItem("Delete order",
                deleteOrderImpl, rootMenu));
        orderMenu.addMenuItem(new MenuItem("Update order",
                updateOrderImpl, rootMenu));
        orderMenu.addMenuItem(new MenuItem("Get by id order",
                getByIdOrderImpl, rootMenu));
        orderMenu.addMenuItem(new MenuItem("get all order",
                getAllOrderImpl, rootMenu));
        orderMenu.addMenuItem(new MenuItem("Save stores to order",
                saveToFileOrderImpl, rootMenu));
        return orderMenu;
    }

    private Menu createProductMenu() {
        var productMenu = new Menu();
        productMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        productMenu.addMenuItem(new MenuItem("Add product",
                addProductImpl, rootMenu));
        productMenu.addMenuItem(new MenuItem("Delete product",
                deleteProductImpl, rootMenu));
        productMenu.addMenuItem(new MenuItem("Update product",
                updateProductImpl, rootMenu));
        productMenu.addMenuItem(new MenuItem("Get by id product",
                getByIdProductImpl, rootMenu));
        productMenu.addMenuItem(new MenuItem("get all product",
                getAllProductImpl, rootMenu));
        productMenu.addMenuItem(new MenuItem("Save products to file",
                saveToFileProductImpl, rootMenu));
        return productMenu;
    }

    private Menu createOrderItemMenu() {
        var orderItemMenu = new Menu();
        orderItemMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        orderItemMenu.addMenuItem(new MenuItem("Add orderItem",
                addOrderItemImpl, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Delete orderItem",
                deleteOrderItemImpl, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Update orderItem",
                updateOrderItemImpl, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Get by id orderItem",
                getByIdOrderItemImpl, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("get all orderItem",
                getAllOrderItemImpl, rootMenu));
        orderItemMenu.addMenuItem(new MenuItem("Save orderItem to file",
                saveToFileOrderItemImpl, rootMenu));
        return orderItemMenu;
    }

    private Menu createShopProductMenu() {
        var shopProductMenu = new Menu();
        shopProductMenu.addMenuItem(new MenuItem("Exit",
                () -> System.out.println(""), null));
        shopProductMenu.addMenuItem(new MenuItem("Add shopProduct",
                addShopProductImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Delete shopProduct",
                deleteShopProductImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Update shopProduct",
                updateShopProductImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get by id shopProduct",
                getByIdShopProductImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get all shopProducts",
                getAllShopProductImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Sort all products by shopPrice",
                sortShopProductByPriceImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Find shopProduct by one attribute",
                findShopProductByOneAttributeImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Find shopProduct by two attributes",
                findShopProductByTwoAttributeImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Get shopProduct from category",
                getShopProductFromCategoryImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem(
                "Get info about product's price and quantity in store",
                infoAboutPriceQuantityInStoreImpl, rootMenu));
        shopProductMenu.addMenuItem(new MenuItem("Save shopProducts to file",
                saveToFileShopProductImpl, rootMenu));
        return shopProductMenu;
    }
}
