package com.exposit.menu;

import com.exposit.api.service.ICustomerService;
import com.exposit.api.service.IProductService;
import com.exposit.api.service.IOrderService;
import com.exposit.api.service.IStoreService;
import com.exposit.model.*;
import com.exposit.model.utils.PriceQuantityInStore;
import com.exposit.service.CustomerService;
import com.exposit.service.ProductService;
import com.exposit.service.OrderService;
import com.exposit.service.StoreService;

import java.util.List;
import java.util.Map;

public class Fasade {

    private static final IStoreService storeService = StoreService.getInstance();
    private static final ICustomerService customerService = CustomerService.getInstance();
    private static final IProductService productService = ProductService.getInstance();
    private static final IOrderService orderService = OrderService.getInstance();

    public Store addStore(String storeName, String internetPage, String phoneNumber) {
        return storeService.addStore(storeName, internetPage, phoneNumber);
    }

    public void deleteStore(Long storeId) {
        storeService.deleteStore(storeId);
    }

    public void updateStore(Long storeId, String storeName, String internetPage, String phoneNumber) {
        storeService.updateStore(storeId, storeName, internetPage, phoneNumber);
    }

    public Store getStoreById(Long storeId) {
        return storeService.getStoreById(storeId);
    }

    public List<Store> getAllStore() {
        return storeService.getAllStore();
    }

    public Order addOrder(Long days, Customer customer, Map<Product, Integer> mapOfGoods) {
        return orderService.addOrder(days, customer, mapOfGoods);
    }

    public void deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
    }

    public void updateOrder(Long orderId, Long days, Customer customer, Map<Product, Integer> mapOfGoods) {
        orderService.updateOrder(orderId, days, customer, mapOfGoods);
    }

    public Order getOrderById(Long orderId) {
        return orderService.getOrderById(orderId);
    }

    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    public Product addProduct(String productName, String productProducer, Integer productPrice,
                              Integer productQuantity, Store store, CategoryOne categoryOne,
                              CategoryTwo categoryTwo, CategoryThree categoryThree) {
        return productService.addProduct(productName, productProducer, productPrice,
                productQuantity, store, categoryOne,
                categoryTwo, categoryThree);
    }

    public void deleteProduct(Long productId) {
        productService.deleteProduct(productId);
    }

    public void updateProduct(Long productId, String productName, String productProducer, Integer productPrice,
                              Integer productQuantity, Store store, CategoryOne categoryOne,
                              CategoryTwo categoryTwo, CategoryThree categoryThree) {
        productService.updateProduct(productId, productName, productProducer, productPrice,
                productQuantity, store, categoryOne, categoryTwo, categoryThree);
    }

    public List<Product> findByTwoAttribute(String value1, String attribute1,
                                            String value2, String attribute2) {
        return productService.findByTwoAttribute(value1, attribute1, value2, attribute2);
    }

    public List<Product> findByOneAttribute(String value, String attribute) {
        return productService.findByOneAttribute(value, attribute);
    }

    public List<PriceQuantityInStore> infoAboutPriceQuantityInStore(String storeName) {
        return productService.infoAboutPriceQuantityInStore(storeName);
    }

    public List<Product> sortByPrice() {
        return productService.sortByPrice();
    }

    public List<Product> getProductFromCategory(String category) {
        return productService.getProductFromCategory(category);
    }

    public Product getProductById(Long productId) {
        return productService.getProductById(productId);
    }

    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    public Customer addCustomer(String firstName, String lastName, String customerAdress, String customerEmail) {
        return customerService.addCustomer(firstName, lastName, customerAdress, customerEmail);
    }

    public void deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);
    }

    public void updateCustomer(Long customerId, String firstName, String lastName, String customerAdress, String customerEmail) {
        customerService.updateCustomer(customerId, firstName, lastName, customerAdress, customerEmail);
    }

    public Customer getCustomerById(Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    public void saveAllStoresToFile() {
        storeService.saveStoreToFile();
    }

    public void saveAllProductsToFile() {
        productService.saveProductToFile();
    }

    public void saveAllOrdersToFile() {
        orderService.saveOrderToFile();
    }

    public void saveAllCustomersToFile() {
        customerService.saveCustomerToFile();
    }
}





