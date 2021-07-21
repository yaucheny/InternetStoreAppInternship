package com.exposit.idGenerators;

public class IdGenerator {

    private static Long orderId = 1L;
    private static Long customerId = 1L;
    private static Long storeId = 1L;
    private static Long productId = 1L;
    private static Long shopProductId = 1L;
    private static Long orderItemId = 1L;
    private static Long categoryId = 1L;

    public static Long generateOrderId() {
        return orderId++;
    }

    public static Long generateCustomerId() {
        return customerId++;
    }

    public static Long generateStoreId() {
        return storeId++;
    }

    public static Long generateProductId() {
        return productId++;
    }

    public static Long generateShopProductId() {
        return shopProductId++;
    }

    public static Long generateOrderItemId() {
        return orderItemId++;
    }

    public static Long generateCategoryId() {
        return categoryId++;
    }
}
