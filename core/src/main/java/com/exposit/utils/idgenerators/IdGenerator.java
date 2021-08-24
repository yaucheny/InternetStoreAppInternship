package com.exposit.utils.idgenerators;

import lombok.Setter;

public final class IdGenerator {
    @Setter
    private static Long orderId = 1L;
    @Setter
    private static Long customerId = 1L;
    @Setter
    private static Long storeId = 1L;
    @Setter
    private static Long productId = 1L;
    @Setter
    private static Long shopProductId = 1L;
    @Setter
    private static Long orderItemId = 1L;
    @Setter
    private static Long categoryId = 1L;


    private IdGenerator() {
    }

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
