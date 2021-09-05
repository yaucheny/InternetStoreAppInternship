package com.exposit.menu;

import com.exposit.api.service.CategoryService;
import com.exposit.api.service.CustomerService;
import com.exposit.api.service.OrderItemService;
import com.exposit.api.service.OrderService;
import com.exposit.api.service.ProductService;
import com.exposit.api.service.ShopProductService;
import com.exposit.api.service.StoreService;
import com.exposit.domain.dto.CategoryDto;
import com.exposit.domain.dto.CustomerDto;
import com.exposit.domain.dto.OrderDto;
import com.exposit.domain.dto.OrderItemDto;
import com.exposit.domain.dto.PriceQuantityInStoreDto;
import com.exposit.domain.dto.ProductDto;
import com.exposit.domain.dto.ShopProductDto;
import com.exposit.domain.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class Facade {

    @Autowired

    private StoreService storeService;
    private CategoryService categoryService;
    private CustomerService customerService;
    private ProductService productService;
    private ShopProductService shopProductService;
    private OrderService orderService;
    private OrderItemService orderItemService;

    public void addStore(StoreDto storeDto) {
        storeService.addStore(storeDto);
    }

    public void deleteStore(Long id) {
        storeService.deleteStore(id);
    }

    public void updateStore(Long id, StoreDto storeDto) {
        storeService.updateStore(id, storeDto);
    }

    public StoreDto getStoreById(Long id) {
        return storeService.getStoreById(id);
    }

    public List<StoreDto> getAllStore() {
        return storeService.getAllStore();
    }

    public void saveStoreToFile() {
        storeService.saveStoreToFile();
    }

    public void addCategory(CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
    }

    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }

    public void updateCategory(Long id, CategoryDto categoryDto) {
        categoryService.updateCategory(id, categoryDto);
    }

    public CategoryDto getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    public List<CategoryDto> getAllCategory() {
        return categoryService.getAllCategory();
    }

    public void saveCategoryToFile() {
        categoryService.saveCategoryToFile();
    }


    public void addCustomer(CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
    }

    public void deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
    }

    public void updateCustomer(Long id, CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
    }

    public CustomerDto getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }

    public List<CustomerDto> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    public void saveCustomerToFile() {
        customerService.saveCustomerToFile();
    }

    public void addProduct(ProductDto productDto) {
        productService.addProduct(productDto);
    }

    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }

    public void updateProduct(Long id, ProductDto productDto) {
        productService.updateProduct(id, productDto);
    }

    public ProductDto getProductById(Long id) {
        return productService.getProductById(id);
    }

    public List<ProductDto> getAllProduct() {
        return productService.getAllProducts();
    }

    public void saveProductToFile() {
        productService.saveProductToFile();
    }

    public void addShopProduct(ShopProductDto shopProductDto) {
        shopProductService.addShopProduct(shopProductDto);
    }

    public void deleteShopProduct(Long id) {
        shopProductService.deleteShopProduct(id);
    }

    public void updateShopProduct(Long id, ShopProductDto shopProductDto) {
        shopProductService.updateShopProduct(id, shopProductDto);
    }

    public ShopProductDto getShopProductById(Long id) {
        return shopProductService.getShopProductById(id);
    }

    public List<ShopProductDto> getAllShopProduct() {
        return shopProductService.getAllShopProduct();
    }

    public void saveShopProductToFile() {
        shopProductService.saveShopProductToFile();
    }

    public List<ShopProductDto> sortByPrice() {
        return shopProductService.sortByPrice();
    }

    public List<ShopProductDto> getGoodsFromCategory(String category) {
        return shopProductService.getGoodsFromCategory(category);
    }

    public List<ShopProductDto> findByTwoAttribute(String value1, String attribute1,
                                                   String value2, String attribute2) {
        return shopProductService.findByTwoAttribute(value1, value2, attribute1, attribute2);
    }

    public List<ShopProductDto> findByOneAttribute(String value, String attribute) {
        return shopProductService.findByOneAttribute(value, attribute);
    }

    public List<PriceQuantityInStoreDto> infoAboutPriceQuantityInStore(String storeName) {
        return shopProductService.infoAboutPriceQuantityInStore(storeName);
    }

    public void addOrder(OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    public void deleteOrder(Long id) {
        orderService.deleteOrder(id);
    }

    public void updateOrder(Long id, OrderDto orderDto) {
        orderService.updateOrder(id, orderDto);
    }

    public OrderDto getOrderById(Long id) {
        return orderService.getOrderById(id);
    }

    public List<OrderDto> getAllOrder() {
        return orderService.getAllOrder();
    }

    public void saveOrderToFile() {
        orderService.saveOrderToFile();
    }

    public void addOrderItem(OrderItemDto orderItemDto) {
        orderItemService.addOrderItem(orderItemDto);
    }

    public void deleteOrderItem(Long id) {
        orderItemService.deleteOrderItem(id);
    }

    public void updateOrderItem(Long id, OrderItemDto orderItemDto) {
        orderItemService.updateOrderItem(id, orderItemDto);
    }

    public OrderItemDto getOrderItemById(Long id) {
        return orderItemService.getOrderItemById(id);
    }

    public List<OrderItemDto> getAllOrderItem() {
        return orderItemService.getAllOrderItem();
    }

    public void saveOrderItemToFile() {
        orderItemService.saveOrderItemToFile();
    }

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setShopProductService(ShopProductService shopProductService) {
        this.shopProductService = shopProductService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setOrderItemService(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
}





